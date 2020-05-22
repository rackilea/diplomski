public static void main(String args[]) throws Exception {

    // create 100 elements of dummy data. 
    Integer[] data = new Integer[100];
    for (int i = 0; i < data.length; i++) {
        data[i] = i + 1;
    }

    // create a paginated list with page size 20
    PaginatedList list = new PaginatedList(new JList(data), 20);

    // add it to a frame
    JFrame f = new JFrame();
    f.add(list);
    f.setSize(100, 100);
    f.pack();
    f.setVisible(true);
}