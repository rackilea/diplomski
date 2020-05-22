public class State {

    private String name;
    private String yearFounded;
    private String capitalName;

    public State(String name, String yearFounded, String capitalName) {
        this.name = name;
        this.yearFounded = yearFounded;
        this.capitalName = capitalName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(String yearFounded) {
        this.yearFounded = yearFounded;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }
}