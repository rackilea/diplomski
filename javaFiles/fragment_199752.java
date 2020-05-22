String in = "by username on September 13, 2015, 08:34:02 am";
        //date parsing pattern
    String s = "MMM d, yyyy, HH:mm:ss aaa";
    SimpleDateFormat sdf = new SimpleDateFormat(s, Locale.US);
    try {
        //pattern to get rid of 'by username on'
        String p = "\\w+\\s\\w+\\s\\w+\\s";
        Date d = sdf.parse(in.replaceFirst(p, ""));
        System.out.println(d);
    } catch (ParseException e) {
        e.printStackTrace();
    }