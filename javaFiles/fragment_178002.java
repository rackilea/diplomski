public static String getDateSeparator(){
        String dateString = DateFormat.getInstance().format(new java.util.Date());
        Matcher matcher = Pattern.compile("[^\\w]").matcher(dateString);
        if (!matcher.find())  return null;
        return matcher.group(0);
    }