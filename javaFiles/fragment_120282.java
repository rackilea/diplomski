picker = new Dialog(getActivity());
    picker.setContentView(R.layout.datetime);
    picker.setTitle("Select Date and Time");
    datep = (DatePicker) picker.findViewById(R.id.datePicker);
    timep = (TimePicker) picker.findViewById(R.id.timePicker1);


from.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub

            set = (Button) picker.findViewById(R.id.btnSet);
            set.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO Auto-generated method stub


                    //datep.updateDate(year, month, day);

                    month = datep.getMonth() + 1;
                    day = datep.getDayOfMonth();
                    year = datep.getYear();
                    hour = timep.getCurrentHour();
                    minute = timep.getCurrentMinute();
                    from.setText(year + "-" + month + "-" + day + " "
                            + hour + ":" + minute);
                    picker.dismiss();



                }
            });
            picker.show();
        }
    });