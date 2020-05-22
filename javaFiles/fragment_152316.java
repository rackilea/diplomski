private static void printDrinks(List<int[]> storageRoom, List<int[]> saleRoom){
    int rows = Math.max(storageRoom.size(), saleRoom.size());
    System.out.println("EAN   STOCK   CAPACITY  |  EAN   STOCK   CAPACITY");
    for (int i = 0; i < rows; i++) {
        if (i < storageRoom.size())
            System.out.printf("%3d %7d %10d  |", storageRoom.get(i)[0], storageRoom.get(i)[1], storageRoom.get(i)[2]);
        else
            System.out.printf("%25s", "|");
        if (i < saleRoom.size())
            System.out.printf("  %3d %7d %10d", saleRoom.get(i)[0], saleRoom.get(i)[1], saleRoom.get(i)[2]);
        System.out.println();
    }
}