Collections.sort(datestring, new Comparator<String>() {
    DateFormat df = new SimpleDateFormat("your format");
    @Override
    public int compare(String s1, String s2) {
       try {
            return df.parse(s1).compareTo(df.parse(s2));
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
});