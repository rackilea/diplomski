class MyDate {

    private DayOfWeek dow = DayOfWeek.MONDAY;// DayOfWeek.of(LocalDate.now().getDayOfWeek());

    @JsonIgnore
    public DayOfWeek getDow() {
        return dow;
    }

    public void setDow(int dow) {
        this.dow = DayOfWeek.of(dow + 1);
    }

    @JsonProperty("dow")
    public int getDayOfWeekNumber() {
        return dow.getValue() - 1; //0 for Monday
    }

    public void setDow(DayOfWeek dow) {
        this.dow = dow;
    }

    @Override
    public String toString() {
        return "[dow=" + dow + "]";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new ObjectMapper().writeValueAsString(new MyDate()));
        System.out.println(new ObjectMapper().readValue("{\"dow\":7}", MyDate.class));
    }
}