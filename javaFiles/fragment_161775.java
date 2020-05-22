public class DateFormatDetector {

    private static final Set<String> DATE_FORMATS = new HashSet<String>();
    static {
        DATE_FORMATS.add("yyyy-MM-dd");
        DATE_FORMATS.add("dd-MM-yyyy");
        DATE_FORMATS.add("MM-dd-yyyy");
    }

    public static Set<String> getPossibleDateFormats(List<String> dates) {
        Set<SimpleDateFormat> candidates = new HashSet<SimpleDateFormat>();
        for (String df : DATE_FORMATS) {
            SimpleDateFormat candidate = new SimpleDateFormat(df);
            candidate.setLenient(false);
            candidates.add(candidate);
        }

        for (String date : dates) {
            Iterator<SimpleDateFormat> it = candidates.iterator();
            while (it.hasNext()) {
                SimpleDateFormat candidate = it.next();
                try {
                    // try to parse the string as a date
                    candidate.parse(date);
                }
                catch (ParseException e) {
                    // failed to parse, so this format is not suitable
                    it.remove();
                }
            }
        }

        Set<String> results = new HashSet<String>();
        for (SimpleDateFormat candidate : candidates)
            results.add(candidate.toPattern());

        return results;
    }
}