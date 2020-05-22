/**
     *
     * @param str_date (in MM/dd/yyyy form)
     * @return string representation of timestamp value, either the string value of the str_date timestamp or "NULL"
     * if can parse str_date to Date object, else returns null
     */
    private String dateString2TimestampString(String str_date) {
        if (str_date.toUpperCase().equals("NULL")) {
            return "NULL";
        } else {
            try {
                // convert date (MM/DD/YYYY) string to java date
                DateFormat formatter;
                formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = (Date) formatter.parse(str_date);

                // convert date string to timestamp (since epoch time) (double??)
                double epochTimestamp = (double) date.getTime();
                return new BigDecimal(epochTimestamp).toPlainString();
            } catch (Exception e) {
                System.out.println("** dateString2TimestampString: could not parse string \"" + str_date + "\" to Date object");
                System.out.println(e.getClass().getCanonicalName());
                System.err.println(e.getMessage());
                System.exit(1);
                return null;
            }
        }
    }