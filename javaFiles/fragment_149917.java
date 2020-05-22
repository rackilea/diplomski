String s1 = "05.05.2015";
 String s2 = "11.05.2015";
 SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
 Calendar calendarFrom = Calendar.getInstance();
 Calendar calendarUntil = Calendar.getInstance();

 calendarFrom.setTime(dateFormat.parse(s1));
 calendarUntil.setTime(dateFormat.parse(s2));
 while (calendarFrom.compareTo(calendarUntil) != 0) {
      System.out.println(dateFormat.format(calendarFrom.getTime()));
      calendarFrom.add(Calendar.DATE, 1);
 }