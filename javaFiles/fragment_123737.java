/*
 * view types
 */
SortCategoryExpand sortCategoryExpand = new SortCategoryExpand();

private static final int VIEW_1 = 0;
private static final int View_2 = 1;
private static final int View_3=2;

/*
 * data
 */
private Context context = null;
ArrayList<Group> groups = new ArrayList<Group>();

public ExpandableListAdapter(Context context) {
    this.context = context;
}

@Override
public int getChildType(int groupPosition, int childPosition) {
    int type = -1;

    if (groupPosition == 2) {
        type = View_3;
    }
    else if (groupPosition == 1) {
        type = View_2;
    }else  {
        type = View_1;
    }

    return type;
}

@Override
public int getChildTypeCount() {
    // Past and Future Travel Plans
    return 3;
}

@Override
public Object getChild(int groupPosition, int childPosition) {
    return groups.get(groupPosition).entryItems.get(childPosition);
}

@Override
public long getChildId(int groupPosition, int childPosition) {
    return childPosition;
}

@Override
public View getChildView(int groupPosition, int childPosition,
        boolean isLastChild, View convertView, ViewGroup parent) {

    // get the type of the group this child belongs
    Type viewType = groups.get(groupPosition).type;
    View view = convertView;

    if (viewType == Type.Data1) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(
                    R.layout.category_absence_line_item, parent, false);

            Data1ViewHolder holder = new Data1ViewHolder ();
            holder.txtSubject = (TextView) view.findViewById(R.id.subject);
            holder.txtFromUser = (TextView) view.findViewById(R.id.user);
            holder.txtStartDate = (TextView) view
                    .findViewById(R.id.startDate);
            holder.txtEndDate = (TextView) view.findViewById(R.id.endDate);

            view.setTag(holder);
        }

        Data1ViewHolder holder = (Data1ViewHolder ) view.getTag();

        EntryItem entryItem = (EntryItem) getChild(groupPosition,
                childPosition);

        if (entryItem.subject.equals("None")) {
            holder.txtSubject.setText("None");
        } else {

            holder.txtSubject.setText("" + entryItem.subject);
        }
        if (entryItem.fromUser.equals("None")) {
            holder.txtFromUser.setText("");
        } else if (entryItem.fromUser.equals("anyType{}")) {
            holder.txtFromUser.setText("From User : ");
        } else {
            holder.txtFromUser.setText("From User : " + entryItem.fromUser);
        }
        if (new SimpleDateFormat("dd-MMM-yyyy").format(entryItem.startDate)
                .equals("01-Jan-1970")) {
            holder.txtStartDate.setText("Start Date : None");
        } else if (new SimpleDateFormat("dd-MMM-yyyy").format(
                entryItem.startDate).equals("03-Mar-3800")) {
            holder.txtStartDate.setText("");
        } else {
            holder.txtStartDate.setText("Start Date : "
                    + new SimpleDateFormat("dd-MMM-yyyy")
                            .format(entryItem.startDate));
        }

        if (new SimpleDateFormat("dd-MMM-yyyy").format(entryItem.endDate)
                .equals("01-Jan-1970")) {
            holder.txtEndDate.setText("Due Date : None");
        } else if (new SimpleDateFormat("dd-MMM-yyyy").format(
                entryItem.endDate).equals("03-Mar-3800")) {
            holder.txtStartDate.setText("");
        } else {
            holder.txtEndDate.setText("Due Date : "
                    + new SimpleDateFormat("dd-MMM-yyyy")
                            .format(entryItem.endDate));
        }
    }else ifviewType == Type.Data2){

        if (view == null) {
            view = LayoutInflater.from(context).inflate(
                    R.layout.category_ticket_line_item, parent, false);

            Data2ViewHolder holder = new Data2ViewHolder ();
            holder.txtSubject = (TextView) view.findViewById(R.id.subject);
            holder.txtFromUser = (TextView) view.findViewById(R.id.user);
            holder.txtStartDate = (TextView) view
                    .findViewById(R.id.startDate);
            holder.txtEndDate = (TextView) view.findViewById(R.id.endDate);

            view.setTag(holder);
        }

        Data2ViewHolder holder = (Data2ViewHolder ) view.getTag();

        EntryItem entryItem = (EntryItem) getChild(groupPosition,
                childPosition);

        if (entryItem.subject.equals("None")) {
            holder.txtSubject.setText("None");
        } else {

            holder.txtSubject.setText("" + entryItem.subject);
        }
        if (entryItem.fromUser.equals("None")) {
            holder.txtFromUser.setText("");
        } else if (entryItem.fromUser.equals("anyType{}")) {
            holder.txtFromUser.setText("From User : ");
        } else {
            holder.txtFromUser.setText("From User : " + entryItem.fromUser);
        }
        if (new SimpleDateFormat("dd-MMM-yyyy").format(entryItem.startDate)
                .equals("01-Jan-1970")) {
            holder.txtStartDate.setText("Start Date : None");
        } else if (new SimpleDateFormat("dd-MMM-yyyy").format(
                entryItem.startDate).equals("03-Mar-3800")) {
            holder.txtStartDate.setText("");
        } else {
            holder.txtStartDate.setText("Start Date : "
                    + new SimpleDateFormat("dd-MMM-yyyy")
                            .format(entryItem.startDate));
        }

        if (new SimpleDateFormat("dd-MMM-yyyy").format(entryItem.endDate)
                .equals("01-Jan-1970")) {
            holder.txtEndDate.setText("Due Date : None");
        } else if (new SimpleDateFormat("dd-MMM-yyyy").format(
                entryItem.endDate).equals("03-Mar-3800")) {
            holder.txtStartDate.setText("");
        } else {
            holder.txtEndDate.setText("Due Date : "
                    + new SimpleDateFormat("dd-MMM-yyyy")
                            .format(entryItem.endDate));
        }

    }
    else if(viewType == Type.Data3){

        if (view == null) {
            view = LayoutInflater.from(context).inflate(
                    R.layout.category_timesheet_line_item, parent, false);

            Data3ViewHolder holder = new Data3ViewHolder ();
            holder.txtSubject = (TextView) view.findViewById(R.id.subject);
            holder.txtFromUser = (TextView) view.findViewById(R.id.user);
            holder.txtStartDate = (TextView) view
                    .findViewById(R.id.startDate);
            holder.txtEndDate = (TextView) view.findViewById(R.id.endDate);

            view.setTag(holder);
        }

        Data3ViewHolder holder = (Data3ViewHolder ) view.getTag();

        EntryItem entryItem = (EntryItem) getChild(groupPosition,
                childPosition);

        if (entryItem.subject.equals("None")) {
            holder.txtSubject.setText("None");
        } else {

            holder.txtSubject.setText("" + entryItem.subject);
        }
        if (entryItem.fromUser.equals("None")) {
            holder.txtFromUser.setText("");
        } else if (entryItem.fromUser.equals("anyType{}")) {
            holder.txtFromUser.setText("From User : ");
        } else {
            holder.txtFromUser.setText("From User : " + entryItem.fromUser);
        }
        if (new SimpleDateFormat("dd-MMM-yyyy").format(entryItem.startDate)
                .equals("01-Jan-1970")) {
            holder.txtStartDate.setText("Start Date : None");
        } else if (new SimpleDateFormat("dd-MMM-yyyy").format(
                entryItem.startDate).equals("03-Mar-3800")) {
            holder.txtStartDate.setText("");
        } else {
            holder.txtStartDate.setText("Start Date : "
                    + new SimpleDateFormat("dd-MMM-yyyy")
                            .format(entryItem.startDate));
        }

        if (new SimpleDateFormat("dd-MMM-yyyy").format(entryItem.endDate)
                .equals("01-Jan-1970")) {
            holder.txtEndDate.setText("Due Date : None");
        } else if (new SimpleDateFormat("dd-MMM-yyyy").format(
                entryItem.endDate).equals("03-Mar-3800")) {
            holder.txtStartDate.setText("");
        } else {
            holder.txtEndDate.setText("Due Date : "
                    + new SimpleDateFormat("dd-MMM-yyyy")
                            .format(entryItem.endDate));
        }

    }
    return view;
}

@Override
public int getChildrenCount(int groupPosition) {
    return groups.get(groupPosition).entryItems.size();
}

@Override
public Object getGroup(int groupPosition) {
    return groups.get(groupPosition);
}

@Override
public int getGroupCount() {
    return groups.size();
}

@Override
public long getGroupId(int groupPosition) {
    return groupPosition;
}

@Override
public View getGroupView(int groupPosition, boolean isExpanded,
        View convertView, ViewGroup parent) {

    Type viewType = groups.get(groupPosition).type;
    View view = convertView;

    if (viewType == Type.Data1) {
        view = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(
                    R.layout.expandable_list_group_absenceview, parent,
                    false);

            Data1ViewHolder holder = new Data1ViewHolder ();
            holder.textabsence = (TextView) view
                    .findViewById(R.id.AbsencegroupHeader);
            holder.imageAbsence = (ImageView) view
                    .findViewById(R.id.AbsenceexpandableIcon);
            view.setTag(holder);
        }

        Data1ViewHolder holder = (Data1ViewHolder ) view.getTag();

        holder.textabsence.setText("Human Resource Absence" + " " + "("
                + groups.get(groupPosition).entryItems.size() + ")");

        if (groups.get(groupPosition).entryItems.size() == 0) {
            holder.imageAbsence.setVisibility(View.INVISIBLE);
        } else {
            int imageResourceId = isExpanded ? android.R.drawable.arrow_up_float
                    : android.R.drawable.arrow_down_float;
            holder.imageAbsence.setImageResource(imageResourceId);

            holder.imageAbsence.setVisibility(View.VISIBLE);
        }
    }else if(viewType == Type.Data2) {
        view = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(
                    R.layout.expandable_list_group_ticketview, parent,
                    false);

            Data2ViewHolder holder = new Data2ViewHolder ();
            holder.textticket = (TextView) view
                    .findViewById(R.id.TicketgroupHeader);
            holder.imageTicket= (ImageView) view
                    .findViewById(R.id.TicketexpandableIcon);
            view.setTag(holder);
        }

        Data2ViewHolder holder = (Data2ViewHolder) view.getTag();

        holder.textticket.setText("Ticket Approvals" + " " + "("
                + groups.get(groupPosition).entryItems.size() + ")");

        if (groups.get(groupPosition).entryItems.size() == 0) {
            holder.imageTicket.setVisibility(View.INVISIBLE);
        } else {
            int imageResourceId = isExpanded ? android.R.drawable.arrow_up_float
                    : android.R.drawable.arrow_down_float;
            holder.imageTicket.setImageResource(imageResourceId);

            holder.imageTicket.setVisibility(View.VISIBLE);
        }
    }
    else if(viewType == Type.Data3) {
        view = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(
                    R.layout.expandable_list_group_timesheetview, parent,
                    false);

            Data3ViewHolder holder = new Data3ViewHolder ();
            holder.texttimesheet = (TextView) view
                    .findViewById(R.id.TimesheetgroupHeader);
            holder.imageTimesheet= (ImageView) view
                    .findViewById(R.id.TimesheetexpandableIcon);
            view.setTag(holder);
        }

        Data3ViewHolder holder = (Data3ViewHolder ) view.getTag();

        holder.texttimesheet.setText("TimeSheet Approvals" + " " + "("
                + groups.get(groupPosition).entryItems.size() + ")");

        if (groups.get(groupPosition).entryItems.size() == 0) {
            holder.imageTimesheet.setVisibility(View.INVISIBLE);
        } else {
            int imageResourceId = isExpanded ? android.R.drawable.arrow_up_float
                    : android.R.drawable.arrow_down_float;
            holder.imageTimesheet.setImageResource(imageResourceId);

            holder.imageTimesheet.setVisibility(View.VISIBLE);
        }
    }
    return view;
}

@Override
public boolean hasStableIds() {
    return true;
}

@Override
public boolean isChildSelectable(int groupPosition, int childPosition) {
    return true;
}

public void setupTrips(ArrayList<EntryItem> aryAbsence,ArrayList<EntryItem> aryTicket, ArrayList<EntryItem> aryTimeSheet) {
    groups.clear();

    if (aryAbsence != null) {
        Group g1 = new Group();
        g1.type = Type.Absence;
        g1.entryItems.clear();
        g1.entryItems = new ArrayList<EntryItem>(aryAbsence);

        groups.add(g1);
    }
    if (aryTicket != null) {
        Group g2 = new Group();
        g2.type = Type.Ticket;
        g2.entryItems.clear();
        g2.entryItems = new ArrayList<EntryItem>(aryTicket);

        groups.add(g2);
    }
    if (aryTimeSheet != null) {
        Group g3 = new Group();
        g3.type = Type.TimeSheet;
        g3.entryItems.clear();
        g3.entryItems = new ArrayList<EntryItem>(aryTimeSheet);

        groups.add(g3);
    }


    notifyDataSetChanged();
}

/*
 * Holder for the Past view type
 */

public static class Data1ViewHolder {
    public ImageView imageAbsence;
    public TextView textabsence;
    public TextView txtEndDate;
    public TextView txtStartDate;
    public TextView txtFromUser;
    public TextView txtSubject;

}

public static class Data2ViewHolder {
    public ImageView imageTicket;
    public TextView textticket;
    public TextView txtEndDate;
    public TextView txtStartDate;
    public TextView txtFromUser;
    public TextView txtSubject;

}
public static class Data3ViewHolder {
    public ImageView imageTimesheet;
    public TextView texttimesheet;
    public TextView txtEndDate;
    public TextView txtStartDate;
    public TextView txtFromUser;
    public TextView txtSubject;

}

/*
 * Wrapper for each group that contains the list elements and the type of
 * travel.
 */
public static class Group {
    public enum Type {
        Data_1,Data_2,Data_3;
    };

    public Type type;
    ArrayList<EntryItem> entryItems = new ArrayList<EntryItem>();
}

}