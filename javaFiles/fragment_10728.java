Calendar now = Calendar.getInstance();
now.set(Calendar.HOUR_OF_DAY, 12);
now.set(Calendar.MINUTE, 30);
Calendar givenDate = Calendar.getInstance();
givenDate.setTime(yourDate);

boolean isBefore = now.before(givenDate);