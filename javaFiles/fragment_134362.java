private static Converter getDateConverter() {
    return new Converter() {
        @SuppressWarnings({ "unchecked", "rawtypes" })
        @Override
        public Object convert(Class classType, Object value) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            try {
                date = value.equals("0") ? new Date(0) : sdf.parse((String) value);
            } catch (ParseException e) {
                // Do nothing
            }
            return date;
        }
    };
}