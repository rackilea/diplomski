public static <T> T objectify(String content, TypeReference valueType) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS");
        dateFormat.setTimeZone(Calendar.getInstance().getTimeZone());
        mapper.setDateFormat(dateFormat);
        return mapper.readValue(content, valueType);
    } catch (Exception e) {
        LOG.log(Level.WARNING, "returning null because of error : {0}", e.getMessage());
        return null;
    }
}