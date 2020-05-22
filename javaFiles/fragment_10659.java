private static final String[] patterns = {
    "yyyy-MM-dd HH:mm",
    "yyyy-MM-dd'T'HH:mm",
    "yyyy-MM-dd HH:mm"
};

public static Date test(String value) throws ... {
    for (String pattern : patterns) {
        try {
           DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
           return df.parse(value);
        } catch (ParseException e) {
           // No-op - move onto the next pattern
        }
    }
    // Do whatever you want here - throw ParseException, or return null
}