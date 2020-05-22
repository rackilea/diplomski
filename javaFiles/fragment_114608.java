DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a") {
        public synchronized Date parse(String source) throws ParseException {
            Calendar cal = Calendar.getInstance();
            Date d = super.parse(source);
            cal.setTime(d);
            if (cal.get(Calendar.YEAR) > 9999 ) {
                throw new ParseException("Year too long", 11);
            }
            return d;
        };
    };