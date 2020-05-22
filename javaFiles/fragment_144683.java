DateFormat df = new SimpleDateFormat("MMddyy");
Date date = df.parse("4 1 01"); // runs successfully (as you know)

DateFormat df = new SimpleDateFormat("MMddyy");
Date date = df.parse("41 01"); // 5 character String - runs successfully

DateFormat df = new SimpleDateFormat("MMddyy");
df.setLenient(false);
Date date = df.parse("41 01"); // 5 character String - causes exception

DateFormat df = new SimpleDateFormat("MMddyy");
Date date = df.parse("999999"); // 6 character String - runs successfully

DateFormat df = new SimpleDateFormat("MMddyy");
df.setLenient(false);
Date date = df.parse("999999"); // 6 character String - causes exception