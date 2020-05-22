public static void main(String[] args) {
    // TODO Auto-generated method stub

    WriteFile ob = new WriteFile();
    ArrayList list = new ArrayList();
    list.add(new details("A", 20, 1));
    list.add(new details("B", 30, 2));

    ob.writeXmlFile(list);
}