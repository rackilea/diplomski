String extra1 = "number +919999999990  time at:07:42:45 on 10.04.2014, number +919999999991 time at:08:42:45 on 11.05.2014, number +919999999992 time at:075:42:45 on 05.03.2014 , number +9199999999913 ,time at:27:40:45 on 09.04.2015.";
    Pattern pattern = Pattern.compile("\\+\\d{12}");
    Matcher matcher = pattern.matcher(extra1);
    System.out.println("matcher.groupCount() " + matcher.groupCount());
    while (matcher.find()) {
        System.out.println(matcher.group());
    }