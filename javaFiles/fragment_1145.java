public void m1(Object n) {
    m1(n, 0);
}

private void m1(Object n, int count) {
    List nl = n.getChildren();
    int nlsize = nl.size();
    for (int i = 0; i < nlsize; i++) {
        String objName = nl.getObjAt(i).getText();
        for (int tab = 0; tab < count; tab++) {
            System.out.print("\t");
        }
        System.out.println(objName);
        m1(nl.getObjAt(i), count + 1);
    }
}