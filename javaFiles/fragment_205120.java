public class VariableDateParser {

    private static final Pattern DATE_PATTERN = Pattern
    .compile("((?:(?:\\d+(?:[./]\\s*)?)+)?)\\s*((?:(?:\\d+[:]?)+)?)");

    public Date getDate(final String dateString) {
        final Calendar calendar = Calendar.getInstance();
        final Matcher matcher = DATE_PATTERN.matcher(dateString);
        if (matcher.matches()) {
            final String dateGroup = matcher.group(1).trim();
            if (!"".equals(dateGroup)) {
                final Iterator<Integer> fields = Arrays.asList(
                    Calendar.DATE, Calendar.MONTH, Calendar.YEAR).iterator();
                final String[] items = dateGroup.split("\\D+");
                for (final String item : items) {
                    if ("".equals(item))
                        break;
                    else if (fields.hasNext()) {
                        final Integer field = fields.next();
                        calendar.set(field, Integer.parseInt(item) -
                           // months are 0-based, grrrr!!!
                           (field.equals(Calendar.MONTH) ? 1 : 0));
                    } else {
                        throw new IllegalArgumentException(
                            "Bad date part: " + dateGroup);
                    }
                }
            }
            final String timeGroup = matcher.group(2).trim();
            if (!"".equals(timeGroup)) {
                final Iterator<Integer> fields = Arrays.asList(
                    Calendar.HOUR, Calendar.MINUTE, Calendar.SECOND,
                    Calendar.MILLISECOND).iterator();
                final String[] items = timeGroup.split("\\D+");
                for (final String item : items) {
                    if ("".equals(item))
                        break;
                    else if (fields.hasNext()) {
                        final Integer field = fields.next();
                        calendar.set(field, Integer.parseInt(item));
                    } else {
                        throw new IllegalArgumentException(
                            "Bad time part: " + timeGroup);
                    }
                }
            }

        } else
            throw new IllegalArgumentException(
                "Bad date string: " + dateString);
        return calendar.getTime();
    }

}