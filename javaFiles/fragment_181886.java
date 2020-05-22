public static void main(String[] args) throws Exception {
    Boolean aiStarts = true;
    Integer size = 9, step = 0;
    List<Spot> board = new ArrayList<>(Collections.nCopies(size, Spot.E));

    do {
        int i;
        do {
            i = (int)(Math.random() * size);
        } while (!Spot.E.equals(board.get(i)));
        board.set(i, step++ % 2 == (aiStarts ? 0 : 1) ? Spot.X : Spot.O);
    } while (board.stream().filter(s -> Spot.E.equals(s)).count() > 0);

    System.out.println(board.subList(0, 3));
    System.out.println(board.subList(3, 6));
    System.out.println(board.subList(6, 9));
}

enum Spot {
    X, O, E;
}