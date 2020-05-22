public class RatioComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        return (int) (o1.getWinRatio() - o2.getWinRatio());
    }

}

public class NameComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        return o1.getUserName().compareTo(o2.getUserName());
    }

}

public class ChainedComparator implements Comparator<Player> {

    private Comparator<Player>[] comparators;

    public ChainedComparator(Comparator<Player>... comparators) {
        this.comparators = comparators;
    }

    @Override
    public int compare(Player o1, Player o2) {
        int result = -1;
        for (Comparator<Player> proxy : comparators) {
            result = proxy.compare(o1, o2);
            if (result != 0) {
                break;
            }
        }
        return result;
    }
}