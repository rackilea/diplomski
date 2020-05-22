// use lowercase "y" for year
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Collections.sort(days, (s1, s2) -> {
    try {
        return sdf.parse(s1).compareTo(sdf.parse(s2));
    } catch (ParseException e) {
        // what to do when parse fails? just ignore and go on? throw exception?
    }
    return 0; // return something or throw exception?
});