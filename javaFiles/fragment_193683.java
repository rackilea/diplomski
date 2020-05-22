JXDatePicker picker = new JXDatePicker(System.currentTimeMillis());
         final JXMonthView monthView = picker.getMonthView();
         monthView.setSelectionMode(JXMonthView.SelectionMode.SINGLE_INTERVAL_SELECTION);
         monthView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println((monthView.getSelection()));
            }
         });