public static void main(String h[]) {
    TreeCheck bt = new TreeCheck();

    bt.add(6);
    bt.add(4);
    bt.add(8);
    bt.add(3);
    bt.add(5);
    bt.add(7);
    bt.add(9);

    System.out.println("-------");
    bt.inOrderPrint(bt.root);

}