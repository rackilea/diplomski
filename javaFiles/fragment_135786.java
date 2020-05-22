public static String getDateFromatedString(String inputDate) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");

    Date date = null;
    try {
        date = simpleDateFormat.parse(inputDate);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    if (date == null) {
        return "";
    }

    SimpleDateFormat convetDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    return convetDateFormat.format(date);
}