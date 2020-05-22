class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
    @Override
    public String marshal(LocalDateTime time) throws Exception {
        return time.atZone(ZoneOffset.ofHours(2))
                   .format(DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ssxxx"));
    }
    @Override
    public LocalDateTime unmarshal(String text) throws Exception {
        return ZonedDateTime.parse(text).toLocalDateTime();
    }
}