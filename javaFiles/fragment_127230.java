public static void main(String[] args) throws ParseException {
            SimpleDateFormat dfFrom = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S"),
                            dfTo = new SimpleDateFormat("MM/dd/yyyy hh:mm a");

            System.out.println(dfTo.format(dfFrom.parse("2013-01-02 14:59:27.953")));
    }