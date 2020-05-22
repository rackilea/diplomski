public class Athlete {
    private int id;
    private String firstName;
    private String lastName;
    private List<Race> class1Races;
    private List<Race> class2Races;

    public Athlete() {
        class1Races = new ArrayList<>(4);
        class2Races = new ArrayList<>(4);
    }

    public int getId() {
        return id;
    }

    //...probably more getters, if you need them elsewhere.

    @Override
    public String toString() {
        String idString = Integer.toString(id);
        StringBuilder result = new StringBuilder(60 + idString.length() + firstName.length() + lastName.length() + 52*class1Races.size() + 52*class2Races.size());
        result.append("Athlete Number: ");
        result.append(idString);
        result.append("\nFirst Name: ");
        result.append(firstName);
        result.append("\nFamily Name: ");
        result.append(lastName);
        result.append("\nClass1\n");
        for(Race race : class1Races) {
            result.append(race.toString());
            result.append("\n");
        }
        result.append("Class2\n");
        for(Race race : class2Races) {
            result.append(race.toString());
            result.append("\n");
        }
        return result.toString();
    }

    void setId(int id) {
        this.id = id;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    void addRaceClass1(Race race) {
        class1Races.add(race);
    }

    void addRaceClass2(Race race) {
        class2Races.add(race);
    }
}

public class Race { //And accompanying Race class to hold information about a race.
    private String name;
    private int position;
    private int points;

    public Race(String name,int position,int points) {
        this.name = name;
        this.position = position;
        this.points = points;
    }

    @Override
    public String toString() {
        String positionString = Integer.toString(position);
        String pointsString = Integer.toString(points);
        StringBuilder result = new StringBuilder(42 + name.length() + positionString.length() + pointsString.length());
        result.append("Position and points awarded for ");
        result.append(name);
        result.append(" race: ");
        result.append(positionString);
        result.append("  ");
        result.append(pointsString);
        return result.toString();
    }

    //...probably some getters, if you need them elsewhere.
}