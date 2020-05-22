public static void printArray(String Team, String[] Member, int[] Score, int length) {
    System.out.println("Winning team:" + Team +"\n");
    System.out.println("Player Score" + "\n");
    for (int i = 0; i < length; i++) {
        System.out.printf(Member[i] + ":" + Score[i] + "\n");
    }
}