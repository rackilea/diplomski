// Number of minutes in a year
int year = minutes / 525600;
int remainingMinutes = minutes % 525600;
int day = remainingMinutes / 1440;

System.out.println(minutes + " minutes is approximately " + year + " years and " + day + " days.");