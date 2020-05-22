public static void main (String[] args)
    throws FileNotFoundException {
        System.out.println("This program simulates the random item generator");
        System.out.println("from the game Diablo II.  Happy hunting!");
        System.out.println();
        String file = "monstats.txt";
        LootGenerator lg = new LootGenerator();
        Monster[] array = lg.getArray(file);
        Monster alex = lg.getRandomMonster(array);
}