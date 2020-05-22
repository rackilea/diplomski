final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
final CaldroidListener caldroidListener = new CaldroidListener() {
            @Override
            public void onSelectDate(Date date, View view) {
                eventDate.setText(sdf.format(date));

            }
        };