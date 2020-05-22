public static void level(Node n) {
    level(n, 0);
}

private static void level(Node n, int level) {
   ///..............your logic
   level(n.getLeftSon(), level + 1);
   //...............
   level(n.getRightSon(), level + 1);
}