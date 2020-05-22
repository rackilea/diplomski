class CrudeDistribution {

    final int TRIALS = 20;

    public int getAverageFromDistribution(int upperLimit) {
        return getAverageOfRandomTrials(TRIALS, upperLimit);
    }

    private int getAverageOfRandomTrials(int trials, int upperLimit) {
        double d = 0.0;
        for (int i=0; i<trials; i++) {
            d +=getRandom(upperLimit);
        }
        return (int) (d /= trials);
    }

    private int getRandom(int upperLimit) {
        return (int) (Math.random()*upperLimit)+1;
    }
}