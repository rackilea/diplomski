/**
     *
     * @version
     * $Log: JDayChooserExt.java,v $
     *
     *
     * @author Ofer Yuval
     * 27 Nov 2015
     *
     */
    public class JDayChooserExt extends JDayChooser {

        /**
         * When false, week-first-day will be painted in red, as in  <code>JDayChooser</code>.
         * When true, week-last-day will be painted in red.
         */
        private boolean isColorWeekend = false;

        /**
         * @param weekOfYearVisible
         */
        public JDayChooserExt(boolean weekOfYearVisible) {

            super(weekOfYearVisible);
        }

        /**
         * Initializes the locale specific names for the days of the week.
         */
        @Override
        protected void init() {

            JButton testButton = new JButton();
            oldDayBackgroundColor = testButton.getBackground();
            selectedColor = new Color(160, 160, 160);
            drawDayNames();
            drawDays();

        }

        /**
         * Draws the day names of the day columns.
         */
        private void drawDayNames() {

            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
            dayNames = dateFormatSymbols.getShortWeekdays();

            int Day = calendar.getFirstDayOfWeek();//firstDayOfWeek;

            int coloredDay = (isColorWeekend ) ?  Day -1 : Day;
            if(coloredDay <= 0) {
                coloredDay += 7;
            }


            for (int i = 0; i < 7; i++) {
                if ((maxDayCharacters > 0) && (maxDayCharacters < 5)) {
                    if (dayNames[Day].length() >= maxDayCharacters) {
                        dayNames[Day] = dayNames[Day]
                                .substring(0, maxDayCharacters);
                    }
                }

                days[i].setText(dayNames[Day]);

                if (Day == coloredDay) {
                    days[i].setForeground(sundayForeground);
                } else {
                    days[i].setForeground(weekdayForeground);
                }

                if (Day < 7) {
                    Day++;
                } else {
                    Day -= 6;
                }
            }
        }

        /**
         * @param isColorWeekend the isColorWeekend to set
         */
        public void setColorWeekend(boolean isColorWeekend) {
            this.isColorWeekend = isColorWeekend;
        }


        // ///////////////////////////////////////////////////////////
        // ////////////// DecoratorButton class //////////////////////
        // ///////////////////////////////////////////////////////////

        class DecoratorButton extends JButton {
            private static final long serialVersionUID = -5306477668406547496L;

            public DecoratorButton() {
                setBackground(decorationBackgroundColor);
                setContentAreaFilled(decorationBackgroundVisible);
                setBorderPainted(decorationBordersVisible);
            }

            @Override
            public void addMouseListener(MouseListener l) {
            }

            @Override
            public boolean isFocusable() {
                return false;
            }

            @Override
            public void paint(Graphics g) {
                if ("Windows".equals(UIManager.getLookAndFeel().getID())) {
                    // this is a hack to get the background painted
                    // when using Windows Look & Feel
                    if (decorationBackgroundVisible) {
                        g.setColor(decorationBackgroundColor);
                    } else {
                        g.setColor(days[7].getBackground());
                    }
                    g.fillRect(0, 0, getWidth(), getHeight());
                    if (isBorderPainted()) {
                        setContentAreaFilled(true);
                    } else {
                        setContentAreaFilled(false);
                    }
                }
                super.paint(g);
            }
        };
    }