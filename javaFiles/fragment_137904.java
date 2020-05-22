public class MultiComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        int result = (int) (o1.getWinRatio() - o2.getWinRatio());
        if (result == 0) {
            result = o1.getUserName().compareTo(o2.getUserName());
        }
        return result;
    }

}