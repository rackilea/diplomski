public class Movie {
    private final String name;

    private List<Schedule> showingList;

    public Movie(String name) {
        this.name = name;
        this.showingList = new ArrayList<>();
    }

    public void addShowing(Schedule schedule) {
        this.showingList.add(schedule);
    }

    public List<Schedule> getShowingList() {
        return Collections.unmodifiableList(showingList);
    }

    public String getName() {
        return name;
    }

}