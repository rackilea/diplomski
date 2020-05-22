public static String getDayOfMonthSuffix(final int n) {
        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
            case 1:  return "st";
            case 2:  return "nd";
            case 3:  return "rd";
            default: return "th";
        }
    }

public static void main(String[] args) throws ParseException {
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse("2013-04-19");

        int day = Integer.parseInt(new java.text.SimpleDateFormat("dd").format(d));
        SimpleDateFormat sdf = new SimpleDateFormat("MMMMM dd'" + getDayOfMonthSuffix(day) + "' yyyy");
        String s = sdf.format(d);

        System.out.println(s);
    }