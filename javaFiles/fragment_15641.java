public static void drawPatch(int width, int height, char primary, char secondary) {
    for (int j = 0; j < height; j++) {
        for (int i = 0; i < width; i++) {
            if ((i+1) % 2 == 0)
                System.out.print(primary);
            else
                System.out.print(secondary);
        }
        if (j < height - 1) { //go to next line except for last row.
            System.out.print("\n");
        }
    }
}