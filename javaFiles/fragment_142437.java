public static void main(String[] args) {
    BingoCard bc = new BingoCard();
    BingoDrawer bd = new BingoDrawer();
    while(thePlayerWantsToPlay()) { //function to be defined by you
        bc.reset();
        bd.reset();
        System.out.println(bc);
        System.out.println(bd);
        System.out.println(bc.test(bd));
    }
}