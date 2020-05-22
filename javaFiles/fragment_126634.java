public class AllTemps {
    private static final ArrayList<Temperature> temps = new ArrayList<Temperature>();
    private Temperature min = null;

    public AllTemps() { }

    public boolean add(Temperature t) {
        updateMin(t);
        return temps.add(t);
    }

    // Here you would implement any other methods to access the ArrayList that you need

    private void updateMin(Temperature t) {
        if (min == null) {
            min = t;
        } else {
            if(min.getDegrees() > t.getDegrees()) min = t;
        }
    }
}