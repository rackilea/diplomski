private Date parseDate(Map.Entry<String, Object> e) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(e.getKey());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return some date;
    }