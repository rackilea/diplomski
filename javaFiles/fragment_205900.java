Calendar cal = Calendar.getInstance();
cal.clear();
cal.set(1970, Calendar.JANUARY, 0, 0, 0);
cal.set(Calendar.MILLISECOND, 0);

Date startTime = cal.getTime();

cal.set(1970, Calendar.JANUARY, 23, 59, 0);
cal.set(Calendar.MILLISECOND, 0);
Date endTime = cal.getTime();

System.out.println(startTime);
System.out.println(endTime);

Calendar value = Calendar.getInstance();
value.set(1970, Calendar.JANUARY, 0, 0, 0);
value.set(Calendar.MILLISECOND, 0);

System.out.println(value.getTime());

// The Calendar field seems to get ignored and overriden 
// by the UI delegate based on what part of the field
// the cursor is current on (hour or minute)
SpinnerDateModel model = new SpinnerDateModel(value.getTime(), startTime, endTime, Calendar.MINUTE);
JSpinner spinner = new JSpinner(model);
spinner.setEditor(new JSpinner.DateEditor(spinner, "HH:mm"));
spinner.setValue(value.getTime());

add(spinner);