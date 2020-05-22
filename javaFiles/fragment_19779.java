public class State {
    private String stateName;
    private List<String> cities;


    public State(String stateName, List<String> cities) {
        this.stateName = stateName;
        this.cities = cities;
    }

    public String getStateName() {
        return stateName;
    }

    public List<String> getCities() {
        return cities;
    }

    @Override
    String toString(){
     return stateName;
    }

}