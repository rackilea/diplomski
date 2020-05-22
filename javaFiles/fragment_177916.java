@ParseClassName("Workout")
public class ParseWorkout extends ParseObject{

    public List<String> getReps() {
        return getList("Reps");
    }
}