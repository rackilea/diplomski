public class PolicyHolder {
    private int height;
    private int weight;
    private boolean smoker;
    private boolean exerciser;
    private lifeExpectancy;  //Tell hibernate to persist this field

    // getters omitted for brevity's sake.

    public void setHeight(int aHeight) {
        height = aHeight;
        computeLifeExpectancy();
    }

    public void setWeight(int aWeight) {
        weight = aWeight;
        computeLifeExpectancy();
    }

    public void setSmoker(boolean aSmoker) {
        smoker = aSmoker;
        computeLifeExpectancy();
    }

    public void setExerciser(boolean anExerciser) {
        exerciser = anExerciser;
        computeLifeExpectancy();
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    /**
     * Computes and saves the life expectancy.
     */
    private void computeLifeExpectancy() {
        lifeExpectancy = Utilities.computeBMI(height, weight) + (smoker ? 0 : 20) + (exerciser ?20 : 0);
    }
}