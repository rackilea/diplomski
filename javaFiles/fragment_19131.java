public static void main(String[] args) {
    int[] colm = { 1, 2, 3, 4, 5, 67, 87 };
    List l = new ArrayList();
    for(int i: colm)
        l.add(i);

    Collections.shuffle(l);

    for (int i = 0; i < 5; i++)
        System.out.println(l.get(i));

}