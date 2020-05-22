public class TestJXChooser extends JFrame {

        /**
         *
         */
        public TestJXChooser(){

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

            getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
            getContentPane().setLayout(new BorderLayout(5,5));

            //set locale and calendar
            Locale locale = Locale.forLanguageTag("de-DE"); 

            Calendar cal = Calendar.getInstance(locale);
            cal.setTime(new Date());
            //set first day of week
            int firstWeekDay = Calendar.SUNDAY;
            cal.setFirstDayOfWeek(firstWeekDay);

            //-- Toedter JCalendar

            JCalendar jCalendar = new JCalendarExt(null, locale, true, true, false);
            jCalendar.setCalendar(cal);
            jCalendar.setPreferredSize(new Dimension(120, 160));
            jCalendar.getDayChooser().setDayBordersVisible(true);
            jCalendar.setTodayButtonVisible(true);
            jCalendar.setWeekOfYearVisible(false);

            getContentPane().add(jCalendar,BorderLayout.CENTER);

            //-- Toedter JDateChooser
            JCalendar jCalendar2 = new JCalendarExt(null, locale, true, true, false);
            jCalendar2.setCalendar(cal);
            JDateChooser dateChooser = new JDateChooser(jCalendar2, null , "dd.mm.yyyy",null);
            dateChooser.setLocale(locale);

            getContentPane().add(dateChooser,BorderLayout.SOUTH);

            pack();
            setVisible(true);

        }

        /**
         * @param args
         */
        public static void main(String[] args) {

            new TestJXChooser();

        }

    }