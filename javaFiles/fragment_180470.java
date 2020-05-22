class MyObject {

    private Date date;

    public int getHour() {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).getHour();
    }
}