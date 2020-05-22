static void display(ArrayList<Row> arrayList1) {
    Row row;
    row = new Row(111,711,1110,111);
    arrayList1.add(row);
    System.out.println(arrayList1); // passing the arraylist values and adding
                                    // the element    
    // Show the Array

    System.out.println("u\t v\t t\t lamda");
    System.out.println("------------------------------");
    for (Row printRow : arrayList1) {
        System.out.println(
        printRow.getu() + "\t " +
        printRow.getv() + "\t" +
        printRow.gett() + "\t" +
        printRow.getlamda());
    }
}