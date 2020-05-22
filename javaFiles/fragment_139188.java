Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
calendar.setTime(new Date());
calendar.add(Calendar.DATE, n); // n is the number of days upto which to be calculated
Date futureDate = calendar.getTime();
List<String> listOfDates = returnListOfDatesBetweenTwoDates(new Date()
                                                                , futureDate);