// Will definitely work
DateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy",
                                      Locale.US);

// Will definitely not work
DateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy",
                                      Locale.FRANCE);

// Might work - depends on default locale
DateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy")