public class Achievement {
    SparseArray<Statistic> mStatistics = new SparseArray<Statistic>();

    // to get a reference to the statisctics that make this achievement
    public SparseArray<Statistic> getStatics() {
        return mStatistics;
    }

    // add a new Statistic to these Achievement
    public void addStatistic(int statisticId, Statistic newStat) {
        // if we don't already have this particular statistic, add it
        // or maybe update the underlining Statistic?!?
        if (mStatistics.get(statisticId) == null) {
             mStatistic.add(newStat);
        }
    }

    // remove the Statistic
    public void removeStatistic(int statisticId) {
        mStatistic.delete(statisticId);
    }

    // check to see if this achievment has a statistic with this id
    public boolean hasStatistics(int statisticId) {
        return mStatistic.get(statisticId) == null ? false : true;
    }

    // rest of your code
}