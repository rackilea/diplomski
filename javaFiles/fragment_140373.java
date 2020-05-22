public class PopulationComparator implements Comparator<Populated> {

    public int compare(Populated left, Populated right) {
        return left.getPopulation() - right.getPopultion();
    }

}