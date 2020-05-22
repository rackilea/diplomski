// test value
String[] jsonDates = {"/Date(1463667774000-9000)/","/Date(1463667774000)/", "/Date(1463667774000+0400)/"};
//                          | preceded by "("
//                          |       | group 1: timestamp
//                          |       |    | optional group 2: "+" or "-"
//                          |       |    |      | optional group 3
//                          |       |    |      | (within group 2):    
//                          |       |    |      | minutes
//                          |       |    |      |       | followed by ")"
Pattern p = Pattern.compile("(?<=\\()(\\d+)(([-+])(\\d+))?(?=\\))");
for (String jsonDate: jsonDates) {
    Matcher m = p.matcher(jsonDate);
    // matching pattern...
    if (m.find()) {
        // found: parsing timstamp
        long timestamp = Long.parseLong(m.group(1));
        Integer minutes = null;
        Boolean addOrSubstract = null;
        if (m.group(2) != null) {
            // parsing sign
            addOrSubstract = "+".equals(m.group(3)); 
            // parsing minutes
            if (m.group(4) != null) {
                minutes = Integer.parseInt(m.group(4));
            }
        }

        // initializing calendar
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(timestamp));
        // adding/removing minutes if parsed
        if (minutes != null) {
            c.add(
                Calendar.MINUTE, 
                addOrSubstract != null ? 
                (addOrSubstract ? minutes : -minutes) : 0
            );
        }
        Date date = c.getTime();
        System.out.println(date);
    }
    // not matched, different format
    else {
        // TODO error
    }
}