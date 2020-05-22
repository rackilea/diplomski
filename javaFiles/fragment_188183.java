for (int i = 0; i < 3; i++) {
    ArrayList<String[]> items = new ArrayList<String[]>();
    for (int j = 0; j < 5; j++) {
        String name = "Item Code-" + String.valueOf(i) + String.valueOf(j);
        items.add( new String[]{name, price} );
    }
    menues.add(items); // This line is the cause
}