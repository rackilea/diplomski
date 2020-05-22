public class NFLPlayer {

    private final String name;

    private int touchdowns;
    private int passingAttempts;
    private int completedPasses;
    private int passingYards;
    private int interceptions;

    public NFLPlayer(String name) {
        this.name = name;
    }

    // Method names start with a lower case character in Java
    // The name should usually be an imperative 'do something' not a noun ('something')
    // although there are exceptions to this rule (for instance in fluent APIs)
    public double calculateQbRating() {                
        double a = (completedPasses / passingAttempts - 0.3) * 5.0;
        double b = (passingYards / passingAttempts - 3.0) * 0.25;            
        // an AritmeticException will occur if passingAttempts is zero
        double c = (touchdowns / passingAttempts) * 25.0;
        double d = 2.375 - (interceptions / passingAttempts * 25.0);
        return ((a + b + c + d) / 6.0) * 100.0;
    }       

    public String getName() {
        return  name;
    }

    // setter for the touchdowns field
    public void setTouchdowns(int value) {
        touchdowns = value;
    }

    // TODO: add other setters for each private field

    @Override
    public String toString() {
        return String.format("Player %s has QB rating %s", name, calculateQbRating());
    }
}