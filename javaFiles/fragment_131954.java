package com.aarboard.reservation.reservations;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.Duration;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class AarCalendar extends GridLayout
{
private final static Log _log= LogFactory.getLog(AarCalendar.class);
private static final long serialVersionUID = 1L;
private LocalDate   _startDate;
private LocalDate   _endDate;

private LocalDate   _minDate= null;
private LocalDate   _maxDate= null;

private final DateTimeFormatter _dateFormatter = DateTimeFormat.forPattern("dd.MM.yyyy");
private final DateTimeFormatter _dateFormatterSmall = DateTimeFormat.forPattern("d.MMM");
private final String[]    _weekDays= {"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"};
private HashMap<String, Products1JO>   _boats= new HashMap<String, Products1JO>();
private HashMap<String, DayEntry>    _calEntries;

private AddressJO   _user;
private boolean _isAdminUser;

public AarCalendar(AddressJO user, boolean isAdminUser)
{
    _user= user;
    _isAdminUser= isAdminUser;
    setColumns(7);
    setRows(4);
    Products1ManagerDao p1Dao= new Products1ManagerDao();
    ContextSettings cSettings= ContextSettings.instance();
    p1Dao.setDataSource(cSettings.getDataSource());
    List<Products1JO> boats= p1Dao.getAllEntries();

    for (Products1JO boat : boats)
    {
        _boats.put(boat.getPrimaryKey(), boat);
    }

    addStyleName("calendarlayout");
    setRowExpandRatio(1, 10);
    setRowExpandRatio(2, 10);
    setRowExpandRatio(3, 10);
    for (int i=0; i<7; i++)
    {
        setColumnExpandRatio(i, 10);
        Label lbl= new Label(_weekDays[i]);
        lbl.setSizeUndefined();
        lbl.addStyleName("CalendarHeader");
        if (i == 0)
        {
            Button previousWeek= new Button();
            ThemeResource resource = new ThemeResource("img/btn_lt1.gif");
            previousWeek.setIcon(resource);
            previousWeek.setDescription("Eine Woche zurück");
            previousWeek.addStyleName(BaseTheme.BUTTON_LINK);
            HorizontalLayout hl= new HorizontalLayout();
            hl.setMargin(false);
            hl.setSpacing(false);
            hl.setWidth(100, Unit.PERCENTAGE);
            hl.addComponent(previousWeek);
            hl.addComponent(lbl);
            hl.setExpandRatio(lbl, 1);
            hl.setComponentAlignment(lbl, Alignment.MIDDLE_CENTER);
            addComponent(hl, i, 0);
            previousWeek.addClickListener(new ClickListener()
                {
                    @Override
                    public void buttonClick(Button.ClickEvent event)
                    {
                        if (_minDate == null || _minDate.isBefore(_startDate))
                        {
                            LocalDate newStartDate= _startDate.minusDays(7);
                            if (_minDate != null && _minDate.isAfter(newStartDate))
                            {
                                newStartDate= _minDate;
                            }
                            loadCalendarForDate(newStartDate);
                        }
                        else
                        {
                            Notification.show("Am frühesten möglichen Termin", Notification.Type.WARNING_MESSAGE);
                        }
                    }
                });
        }
        else if (i == 6)
        {
            Button nextWeek= new Button();
            ThemeResource resource = new ThemeResource("img/btn_rt1.gif");
            nextWeek.setIcon(resource);
            nextWeek.setDescription("Eine Woche vorwärts");
            nextWeek.addStyleName(BaseTheme.BUTTON_LINK);
            HorizontalLayout hl= new HorizontalLayout();
            hl.setMargin(false);
            hl.setSpacing(false);
            hl.setWidth(100, Unit.PERCENTAGE);
            hl.addComponent(lbl);
            hl.addComponent(nextWeek);
            hl.setExpandRatio(lbl, 1);
            hl.setComponentAlignment(lbl, Alignment.MIDDLE_CENTER);
            addComponent(hl, i, 0);
            nextWeek.addClickListener(new ClickListener()
                {
                    @Override
                    public void buttonClick(Button.ClickEvent event)
                    {
                        if (_maxDate == null || _maxDate.isAfter(_startDate.plusDays(21)))
                        {
                            LocalDate newEndDate= _startDate.plusDays(7);
                            if (_maxDate != null && newEndDate.isAfter(_maxDate))
                            {
                                newEndDate= _maxDate;
                            }
                            loadCalendarForDate(newEndDate);
                        }
                        else
                        {
                            Notification.show("Am spätesten möglichen Termin", Notification.Type.WARNING_MESSAGE);
                        }
                    }
                });
        }
        else
        {
            addComponent(lbl, i, 0);
            setComponentAlignment(lbl, Alignment.MIDDLE_CENTER);
        }
    }
}

public void loadCalendarForDate(LocalDate startDate)
{
    int euDOW= startDate.getDayOfWeek();
    if (euDOW == 0)
    {
        euDOW= 7;
    }
    else
    {
        euDOW= euDOW-1;
    }
    if (_minDate == null)
    {
        _startDate= startDate.minusDays(euDOW);
    }
    else
    {
        LocalDate sDate= startDate.minusDays(euDOW);
        if (sDate.isBefore(_minDate))
        {
            _startDate= startDate;
        }
        else
        {
            _startDate= sDate;
        }
    }
    _calEntries= new HashMap<String, DayEntry>();
    int nRows= getRows();
    int nCols= getColumns();
    for (int row= 1; row <= nRows; row++)
    {
        for (int col= 0; col <= nCols; col++)
        {
            removeComponent(col, row);
        }
    }

    int dayOfWeek= _startDate.getDayOfWeek();
    if (dayOfWeek == 0)
    {
        dayOfWeek= 7;
    }
    else
    {
        dayOfWeek= dayOfWeek-1;
    }
    int maxDaysToDisplay= 21;
    if (_maxDate != null && _maxDate.isBefore(_startDate.plusDays(maxDaysToDisplay)))
    {
        maxDaysToDisplay= maxDaysToDisplay; // TODO Complete end calculation
    }

    for (int i= 0; i < (maxDaysToDisplay-dayOfWeek); i++)
    {
        int colNum= (i+dayOfWeek)  % 7;
        int row= ((i+dayOfWeek) / 7)+1;
        LocalDate ld2= _startDate.plusDays(i);
        _endDate= ld2;
        DayEntry de= new DayEntry(ld2);
        _calEntries.put(ld2.toString(_dateFormatter), de);
        if (colNum == 6)
        {
            de.addStyleName("dayEntryLastCol");
        }
        if (row == 3)
        {
            de.addStyleName("dayEntryLastRow");
        }
        addComponent(de, colNum, row);
    }

    Duration dur= new Duration(_startDate.toDate().getTime(), _endDate.toDate().getTime());
    long nDays= dur.getStandardDays();
    for (int i = 0; i <= nDays; i++) 
    {
        createEventsForDay(_startDate.plusDays(i));
    }
}

void createEventsForDay(LocalDate day) 
{
    ContextSettings cSettings= ContextSettings.instance();
    Events1ManagerDao e1Dao= new Events1ManagerDao();
    e1Dao.setDataSource(cSettings.getDataSource());
    List<Events1JO> events= e1Dao.getAllEntriesForDay(day.toDate());
    ArrayList<ReservationJO> reservations= new ArrayList<ReservationJO>();
    for (Events1JO ev : events)
    {
        reservations.add(new ReservationJO(ev));
    }

    for (ReservationJO res : reservations)
    {
        addEvent(res, false);

    }
    showEntries(day);
}

public class DayEntry extends VerticalLayout
{
    private static final long serialVersionUID = 1L;
    private HashMap<String, VerticalLayout>    _vl= new HashMap<String, VerticalLayout>(); // Hashmap with boatID + VerticalLayouts as container
    private HashMap<String, List<ReservationJO>> _entries= new HashMap<String, List<ReservationJO>>();
    private LocalDate   _currentDay;

    public DayEntry(LocalDate ld)
    {
        setMargin(true);
        _currentDay= ld;
        addStyleName("dayEntry");
        setHeight(100, Unit.PERCENTAGE);
        String caption= ld.toString(_dateFormatter);
        setDescription(caption);
        HorizontalLayout hl= new HorizontalLayout();
        hl.setWidth(100, Unit.PERCENTAGE);
        addComponent(hl);
        Label lbl= new Label(ld.toString(_dateFormatterSmall));
        lbl.setSizeUndefined();
        hl.addComponent(lbl);
        hl.setComponentAlignment(lbl, Alignment.MIDDLE_CENTER);
        HorizontalLayout hl2= new HorizontalLayout();
        addComponent(hl2);
        setExpandRatio(hl2, 10);
        hl2.setSizeFull();
        for (Products1JO boat : _boats.values())
        {
            List<ReservationJO> resList= new ArrayList<ReservationJO>();
            _entries.put(boat.getPrimaryKey(), resList);
            VerticalLayout vl= new VerticalLayout();
            hl2.addComponent(vl);
            vl.setHeight(100, Unit.PERCENTAGE);
            _vl.put(boat.getPrimaryKey(), vl);
        }
    }

    /**
     * Add a entry for this day (It does not automatically update the display
     * Use showEntries for this
     * 
     * @param newEntry 
     */
    public void addEntry(ReservationJO newEntry)
    {
        List<ReservationJO> list= _entries.get(newEntry.getBoatID());
        list.add(newEntry);
    }

    public void removeEntry(ReservationJO newEntry)
    {
        List<ReservationJO> list= _entries.get(newEntry.getBoatID());
        list.remove(newEntry);
    }

    public void showEntries()
    {
        for (VerticalLayout vl : _vl.values())
        {
            vl.removeAllComponents();
        }
        boolean isFirst= true;
        for (String id : _vl.keySet())
        {
            VerticalLayout vl= _vl.get(id);
            Products1JO boat= _boats.get(id);
            String boatCaption= boat.getTitle().get("DE");
            List<ReservationJO> list= _entries.get(id);
            Collections.sort(list, new Comparator<ReservationJO>()
                {
                    public int compare(ReservationJO obj1, ReservationJO obj2)
                    {
                        return obj1.getStartTime() - obj2.getStartTime();
                    }
                });

            int currentHour= StartEndTimeSelector.FIRST_HOUR;
            for (ReservationJO res : list)
            {
                int startTime= res.getStartTime();
                if (startTime > currentHour)
                {
                    // First reservation does not start on first possible hour
                    FreeEntry lbl= new FreeEntry("Frei", boat.getPrimaryKey(), currentHour, startTime);
                    lbl.setData(res);
                    lbl.setDescription(boatCaption);
                    lbl.setSizeFull();
                    lbl.addStyleName( BaseTheme.BUTTON_LINK);
                    lbl.addStyleName("FreeTime");
                    if (!isFirst)
                    {
                        lbl.addStyleName("FreeTimeLeftBorder");
                    }
                    vl.addComponent(lbl);
                    vl.setComponentAlignment(lbl, Alignment.MIDDLE_CENTER);
                    vl.setExpandRatio(lbl, startTime - currentHour);
                    lbl.addClickListener(new ClickListener()
                        {
                            @Override
                            public void buttonClick(Button.ClickEvent event)
                            {
                                ReservationJO res= new ReservationJO();
                                FreeEntry entry= (FreeEntry)(event.getButton());
                                res.setStartEndDate(_currentDay, entry.getStartTime(), entry.getEndTime()); // Default 1 hour
                                res.setBoatID(entry.getBoatID());
                                ReservationDetailsWindow popup= new ReservationDetailsWindow(AarCalendar.this, res, false, false, _isAdminUser);
                                getUI().addWindow(popup);
                            }
                        });    
                }
                currentHour= res.getEndTime();
                BookedEntry lbl= new BookedEntry(startTime+":00-"+currentHour+":00", boatCaption, res);
                lbl.addStyleName( BaseTheme.BUTTON_LINK);
                if (!isFirst)
                {
                    lbl.addStyleName("ReservedTimeLeftBorder");
                }
                lbl.setHeight(100, Unit.PERCENTAGE);

                vl.addComponent(lbl);
                vl.setExpandRatio(lbl, currentHour-startTime);
                vl.setComponentAlignment(lbl, Alignment.MIDDLE_CENTER);
            }
            if (currentHour < StartEndTimeSelector.LAST_HOUR)
            {
                FreeEntry lbl= new FreeEntry("Frei", boat.getPrimaryKey(), currentHour, StartEndTimeSelector.LAST_HOUR);
                lbl.setDescription(boatCaption);
                lbl.addStyleName( BaseTheme.BUTTON_LINK);
                lbl.addStyleName("FreeTime");
                if (!isFirst)
                {
                    lbl.addStyleName("FreeTimeLeftBorder");
                }
                lbl.setSizeFull();
                vl.addComponent(lbl);
                vl.setExpandRatio(lbl, StartEndTimeSelector.LAST_HOUR - currentHour);
                vl.setComponentAlignment(lbl, Alignment.MIDDLE_CENTER);
                lbl.addClickListener(new ClickListener()
                    {
                        @Override
                        public void buttonClick(Button.ClickEvent event)
                        {
                            ReservationJO res= new ReservationJO();
                            FreeEntry entry= (FreeEntry)(event.getButton());
                            res.setStartEndDate(_currentDay, entry.getStartTime(), entry.getEndTime()); // Default 1 hour
                            res.setBoatID(entry.getBoatID());
                            ReservationDetailsWindow popup= new ReservationDetailsWindow(AarCalendar.this, res, false, false, _isAdminUser);
                            getUI().addWindow(popup);
                        }
                    });    
            }
            isFirst= false;
        }
    }

}

public LocalDate getStartDate()
{
    return _startDate;
}

public void addEvent(ReservationJO newEntry, boolean refreshView)
{
    Date startDate= newEntry.getStartDate();
    LocalDate lstartDate= new LocalDate(startDate);
    DayEntry de= _calEntries.get(lstartDate.toString(_dateFormatter));
    if (de != null)
    {
        de.addEntry(newEntry);
        if (refreshView)
        {
            de.showEntries();
        }
    }
    else
    {
        _log.fatal("No such entry found in calendar: "+lstartDate);
    }
}

public void removeEvent(ReservationJO oldEntry, boolean refreshView)
{
    Date startDate= oldEntry.getStartDate();
    LocalDate lstartDate= new LocalDate(startDate);
    DayEntry de= _calEntries.get(lstartDate.toString(_dateFormatter));
    if (de != null)
    {
        de.removeEntry(oldEntry);
        if (refreshView)
        {
            de.showEntries();
        }
    }
    else
    {
        _log.fatal("No such entry found in calendar: "+lstartDate);
    }
}

public void showEntries(LocalDate day)
{
    DayEntry de= _calEntries.get(day.toString(_dateFormatter));
    if (de != null)
    {
        de.showEntries();
    }
    else
    {
        _log.fatal("No such entry found in calendar: "+day);
    }
}
public LocalDate getEndDate()
{
    return _endDate;
}

protected class FreeEntry extends Button
{
    private static final long serialVersionUID = 1L;
    private int _startTime;
    private int _endTime;
    private String _boatID;

    public FreeEntry(String caption, String boatID, int startTime, int endTime)
    {
        super(caption);
        _startTime = startTime;
        _endTime = endTime;
        _boatID = boatID;
    }

    public String getBoatID()
    {
        return _boatID;
    }

    public int getEndTime()
    {
        return _endTime;
    }

    public int getStartTime()
    {
        return _startTime;
    }
}

protected class BookedEntry extends Button
{
    private static final long serialVersionUID = 1L;

    public BookedEntry(String caption, String boatCaption, ReservationJO reservation)
    {
        super(caption);
        setWidth(100, Unit.PERCENTAGE);

        final ReservationJO myReservation= reservation;

        String myAdrID= reservation != null ? reservation.getAddressID() : null;
        boolean isOwn= AarCalendar.this._user.getPrimaryKey().equals(myAdrID);
        if (isOwn)
        {
            setDescription(boatCaption+" "+AarCalendar.this._user.getAddressname());
        }
        else
        {
            if (_isAdminUser)
            {
                ContextSettings cSettings= ContextSettings.instance();
                AddressManagerDao aDao= new AddressManagerDao();
                aDao.setDataSource(cSettings.getDataSource());
                AddressJO address= aDao.getEntry(reservation.getAddressID());
                setDescription(boatCaption+" "+address.getAddressname());
            }
            else
            {
                setDescription(boatCaption);
            }
        }
        addStyleName("ReservationEntry");
        addClickListener(new ClickListener()
            {
                @Override
                public void buttonClick(ClickEvent event)
                {
                    boolean allowDelete= true;
                    allowDelete= _isAdminUser || (myReservation.getAddressID().equals(AarCalendar.this._user.getPrimaryKey()) && !myReservation.isMailSent());
                    ReservationDetailsWindow popup= new ReservationDetailsWindow(AarCalendar.this, myReservation, true, allowDelete, _isAdminUser);
                    getUI().addWindow(popup);
                }
            });
    }
}

public void setMinDate(LocalDate minDate)
{
    _minDate= minDate;
}

public void setMaxDate(LocalDate maxDate)
{
    _maxDate= maxDate;
}
}