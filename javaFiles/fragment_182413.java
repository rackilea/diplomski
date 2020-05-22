public static ArrayList<String> getPositions(ArrayList<Integer> list) {
    ArrayList<String> positions = new ArrayList<String>();
    String[] endings = { "th", "st", "nd", "rd" };
    Integer last = 100;
    Integer lastRank = 1;
    for (int index = 0; index < list.size(); index++) {
        int position = index + 1;
        if (last == list.get(index)) {
            position = lastRank;
        }
        int remainder = position % 10;
        String rank = position + "";
        String ending = endings[0];
        if (remainder <= 3) {
            if ((position % 100) - remainder != 10) {
                ending = endings[remainder];
            }
        }
        rank = rank + ending;
        last = list.get(index);
        lastRank = position;
        positions.add(rank);
    }
    return positions;
}