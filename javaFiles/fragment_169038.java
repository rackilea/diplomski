private List<String> employees = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.employees.add(firstName);
    }