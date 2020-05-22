public static void main(String[] args) {
    CartOrder s = new CartOrder();
    Data d = s.new Data();
    d.setName("Test");
    s.addData(d);
    System.out.println(s);
}