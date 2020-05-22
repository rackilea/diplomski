class TimeManagement {
    private static final double TIME_STEP = 0.5;

    private List<Unit> = new ArrayList<Unit>();
    private List<Building> = new ArrayList<Building>();

    private TimeManagement instance;

    public static TimeManagement getInstance() {
        if (instance == null) {
            instance = new TimeManagement();
        }
        return instance;
    }
}