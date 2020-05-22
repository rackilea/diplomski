public class DiceComparator implements Comparator<Dice>{
    @Override
    public int compare(final Dice o1, final Dice o2) {
        //here comes logic for comparison
        return 0;
    }
}

Arrays.sort(YahtzeeGUI.getGame().getDice(), new DiceComparator());