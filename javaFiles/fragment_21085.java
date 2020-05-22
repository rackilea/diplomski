int month, day, year;
SimpleDateFormat sdf = new SimpleDateFormat(month+"+"+day+"+"+year);

day = UtilsFL.readInt("Enter birth day: ",false); // String mode
month = UtilsFL.readInt("Enter birth month: ",false);
year = UtilsFL.readInt("Enter birth year: ",false);