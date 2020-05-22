public class TestJodaTime {

    public static void main(String[] args) {
        new TestJodaTime();
    }

    public TestJodaTime() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JodaPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class JodaPane extends JPanel {

        private JTextField startHour;
        private JTextField startMin;
        private JTextField endHour;
        private JTextField endMin;
        private JButton diffButton;
        private JLabel lblDiff;
        private JButton markStart;
        private JButton markEnd;
        private Timer timer;
        private JLabel realTime;

        public JodaPane() {

            markStart = new JButton("Mark");
            markEnd = new JButton("Mark");

            startHour = new JTextField(2);
            startMin = new JTextField(2);
            endHour = new JTextField(2);
            endMin = new JTextField(2);
            diffButton = new JButton("=");
            lblDiff = new JLabel("00:00");
            realTime = new JLabel("00:00.00");

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("From"), gbc);
            gbc.gridx++;
            add(startHour, gbc);
            gbc.gridx++;
            add(new JLabel(":"), gbc);
            gbc.gridx++;
            add(startMin, gbc);
            gbc.gridx++;
            add(markStart, gbc);
            gbc.gridx++;
            add(new JLabel(" to "), gbc);
            gbc.gridx++;
            add(endHour, gbc);
            gbc.gridx++;
            add(new JLabel(":"), gbc);
            gbc.gridx++;
            add(endMin, gbc);
            gbc.gridx++;
            add(markEnd, gbc);
            gbc.gridx++;
            add(diffButton, gbc);
            gbc.gridx++;
            add(lblDiff, gbc);

            gbc.gridy++;
            add(realTime, gbc);

            diffButton.addActionListener(new ActionListener() {
                public boolean isValid(JTextField field) {
                    return field.getText() != null && field.getText().length() > 0;
                }
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (isValid(startHour) && isValid(startMin)
                                    && isValid(endHour) && isValid(endMin)) {
                        int hourStart = Integer.parseInt(startHour.getText());
                        int minStart = Integer.parseInt(startMin.getText());
                        int hourEnd = Integer.parseInt(endHour.getText());
                        int minEnd = Integer.parseInt(endMin.getText());

                        String prefix = "";
                        if (hourEnd < hourStart) {
                            int tmp = hourStart;
                            hourStart = hourEnd;
                            hourEnd = tmp;
                            prefix = "-";
                        }

                        System.out.println("Start = " + hourStart + ":" + minStart);
                        System.out.println("End = " + hourEnd + ":" + minEnd);

                        DateTime start = new DateTime(0, 1, 1, hourStart, minStart, 0, 0);
                        DateTime end = new DateTime(0, 1, 1, hourEnd, minEnd, 0, 0);
                        Interval interval = new Interval(start, end);
                        Period toPeriod = interval.toPeriod();

                        PeriodFormatter dateFormat = new PeriodFormatterBuilder()
                                        .printZeroAlways().minimumPrintedDigits(2)
                                        .appendHours().minimumPrintedDigits(2)
                                        .appendSeparator(":")
                                        .appendMinutes().minimumPrintedDigits(2)
                                        .toFormatter();
                        lblDiff.setText(prefix + dateFormat.print(toPeriod));
                    }
                }

            });

            markStart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Calendar cal = Calendar.getInstance();
                    startHour.setText(Integer.toString(cal.get(Calendar.HOUR_OF_DAY)));
                    startMin.setText(Integer.toString(cal.get(Calendar.MINUTE)));
                    diffButton.doClick();
                }

            });
            markEnd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Calendar cal = Calendar.getInstance();
                    endHour.setText(Integer.toString(cal.get(Calendar.HOUR_OF_DAY)));
                    endMin.setText(Integer.toString(cal.get(Calendar.MINUTE)));
                    diffButton.doClick();
                }

            });

            timer = new Timer(500, new ActionListener() {
                private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm.ss");
                @Override
                public void actionPerformed(ActionEvent ae) {
                    realTime.setText(sdf.format(new Date()));
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();


        }

    }

}