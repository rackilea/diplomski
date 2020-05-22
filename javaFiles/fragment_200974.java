class Week {
    public static final String[] DAYS_OF_THE_WEEK = {
      "Monday",
      "Tuesday",
      "Wednesday",
      "Thursday",
      "Friday",
      "Saturday",
      "Sunday",
    };
}

Week.DAYS_OF_THE_WEEK = new String[6];  // error: cannot reassign final variable
Week.DAYS_OF_THE_WEEK[2] = "February";  // this is not prevented!