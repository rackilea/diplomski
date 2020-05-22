public class StrictDecimalFormat extends DecimalFormat {

        private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d*[.]?\\d*$");

        public Number parse(String text, ParsePosition pos) {
            Matcher matcher = NUMBER_PATTERN.matcher(text);
            if (matcher.matches()) {
                return super.parse(text, pos);
            }
            return null;
        }
    }