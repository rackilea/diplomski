public String getPrintIDs() { //Notice new signature
    int i = 0;
    if (id.isEmpty())
        return null;
    System.out.println("printIDs <--");
    Iterator<Integer> it = id.iterator();
    while (it.hasNext()) {
        i++;
        System.out.println(it.next());
    }
    System.out.println("suma produktow: " + i + "\nprintIDs -->");
    pb = new ProductBean();
    StringParse sp = new StringParse();
    idList = sp.prepareInStatement(id);
    try {
        list = pb.getProductByID(idList, 2);
        suma = cumputeCosts(list);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return "TESTprintIDs";
}