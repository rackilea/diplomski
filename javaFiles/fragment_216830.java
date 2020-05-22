Calendar pickedDate = new GregorianCalendar(
        picker.getYear(), 
        picker.getMonth(), 
        picker.getDayOfMonth());
long pickedTime = pickedDate.getTimeInMillis();
long now = new Date().getTime();

if (pickedTime - now <= (280 * 24 * 60 * 60 * 1000)) { // 280 days in milliseconds
  // ...
}