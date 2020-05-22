final Calendar minDate = Calendar.getInstance();
final Calendar.maxDate = Calendar.getInstance();
maxDate.add(Calendar.DAY_OF_MONTH, 30);

ivBack.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (calendarSh.after(minDate)) {
            calendarSh.add(Calendar.DAY_OF_MONTH, -1);
            formattedDate = simpleDateFormat.format(calendarSh.getTime());

            Log.v("PREVIOUS DATE : ", formattedDate);
            tvDate.setText(formattedDate);
        }
    }
});

ivNext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (calendarSh.before(maxDate)) {
            calendarSh.add(Calendar.DAY_OF_MONTH, +1);
            formattedDate = simpleDateFormat.format(calendarSh.getTime());

            Log.v("NEXT DATE : ", formattedDate);
            tvDate.setText(formattedDate);
        }
    }
});