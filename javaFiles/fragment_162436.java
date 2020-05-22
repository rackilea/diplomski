public void printImportantData(ArrayList<Data> dataList, Predicate<Data> p) {
    for (Data d : dataList) {
        if (p.test(d)) {
            System.out.println(d);
        }
    }
}