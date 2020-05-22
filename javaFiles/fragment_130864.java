public static void main(String[] args) {
    ArrayList<PetShop> p = new ArrayList<PetShop>();
    p.add(new PetShop("a", "9", "street 1", "123", "www.a.com"));
    p.add(new PetShop("b", "10", "street 2", "456", "www.b.com"));
    p.add(new PetShop("c", "11", "street 3", "789", "www.c.com"));
    p.add(new PetShop("d", "12", "street 4", "000", "www.d.com"));

    ApplicationViewer v = new ApplicationViewer(p);
    v.setVisible(true);
}