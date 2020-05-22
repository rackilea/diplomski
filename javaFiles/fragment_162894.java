Calendar date1 = Calendar.getInstance();
Calendar date2 = Calendar.getInstance();

date1.clear();
date1.set(
   datePicker1.getYear(),
   datePicker1.getMonth(),
   datePicker1.getDayOfMonth());
date2.clear();
date2.set(
   datePicker2.getYear(),
   datePicker2.getMonth(),
   datePicker2.getDayOfMonth());

long diff = date2.getTimeInMillis() - date1.getTimeInMillis();

float dayCount = (float) diff / (24 * 60 * 60 * 1000);

textView.setText(Long.toString(diff) + " " + (int) dayCount);