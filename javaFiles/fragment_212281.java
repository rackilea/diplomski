public static void main(String[] args) {
    int data[] = new int[10];
    List<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>(9);
    for (int j = 0; j < data.length - 1; j++) {
        lst.add(new ArrayList<Integer>());
        for (int i = 0; i < data.length - 1; i++) {
            lst.get(j).add(i);
        }
    }

    // shuffle can only process 1-dimension array
    for (int j = 0; j < data.length - 1; j++) {
        Collections.shuffle(lst.get(j));
    }

    // display the result in a 2-dimensional array format
    for (int j = 0; j < data.length - 1; j++) {
        for (int i = 0; i < data.length - 1; i++) {
            System.out.print(lst.get(j).get(i) + ", ");
        }
        System.out.println("");
    }
}