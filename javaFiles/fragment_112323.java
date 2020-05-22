public static void main(String[] args) {
        ChineseMenu[] chineseArray = ChineseMenu.values();
        int total = 0;
        for (ChineseMenu menu : chineseArray) {
            total+=menu.getCost();

        }
        System.out.println("The price of Chinese menu is "+total);

}