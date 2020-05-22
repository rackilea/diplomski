/**
     * Extended to gain control on week-first-day.
     * It also enables the option to display in different color the
     * last-day-of-week, rather than <code>JCalendar</code> default which is
     * always display Sunday in a different color.
     *
     * @version
     * $Log: JCalendarExt.java,v $
     *
     *
     * @author Ofer Yuval
     * 27 Nov 2015
     *
     */
    public class JCalendarExt extends JCalendar {

        /**
         *
         * @param date
         * @param locale
         * @param monthSpinner
         * @param weekOfYearVisible
         * @param colorWeekend
         *      <br>When false, week-first-day will be painted in red, as in  <code>JDayChooser</code>.
         *      <br>When true, week-last-day will be painted in red.
         */

        public JCalendarExt(Date date, Locale locale, boolean monthSpinner, boolean weekOfYearVisible,
                boolean colorWeekend) {

            super(date, locale, monthSpinner, weekOfYearVisible);

            remove(dayChooser);

            //add the extended date chooser
            dayChooser = new JDayChooserExt(weekOfYearVisible) ;
            dayChooser.addPropertyChangeListener(this);
            ((JDayChooserExt) dayChooser).setColorWeekend(colorWeekend);

            monthChooser.setDayChooser(dayChooser);
            yearChooser.setDayChooser(dayChooser);

            add(dayChooser, BorderLayout.CENTER);

        }

        @Override
        public void setCalendar(Calendar c) {

            getDayChooser().setCalendar(c);
            super.setCalendar(c);
        }

    }