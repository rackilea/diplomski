class Record {
    String aNumber,
    List<String> routingf, aco, ao, l, miscell;

    public Record(String aNumber) {
        this.aNumber = aNumber;
        this.routingf = new ArrayList<>();
        // init other lists like above ...
    }

    public void addRoutingf(String routingf) {
        // add only of not null and is not empty trimmed
        if(routingf != null && routiingf.trim().length() > 0) {
            this.routingf.add(routiingf);
        }
    }

    // implement add-methods for other lists like above ...
}