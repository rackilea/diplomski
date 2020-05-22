Calendar cal = Calendar.getInstance();
cal.set(Calendar.HOUR_OF_DAY, 0);
cal.set(Calendar.MINUTE, 0);

Date startTime = cal.getTime();
cal.set(Calendar.HOUR, 23);
cal.set(Calendar.MINUTE, 59);
Date endTime = cal.getTime();

System.out.println(startTime);
System.out.println(endTime);

// The Calendar field seems to get ignored and overriden 
// by the UI delegate based on what part of the field
// the cursor is current on (hour or minute)
SpinnerDateModel model = new SpinnerDateModel(startTime, null, endTime, Calendar.MINUTE);
JSpinner spinner = new JSpinner(model);
spinner.setEditor(new JSpinner.DateEditor(spinner, "HH:mm"));

spinner.setValue(startTime);