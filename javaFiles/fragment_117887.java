public MyTimes(String name, Instant startDate) {
    this.name = name;
    this.startDate = startDate;
}

public MyTimes(String name, String startDate) {
    this(name, Instant.parse(startDate));
}