public static void printXinSquare(int width) 
{
    for (int k = 0; k < width; k++) {
        for (int j = 0; j < width; j++) {
            if (k == j || k == width - j - 1) {
                System.out.print("  ");
            }
            else {
                System.out.print("* ");
            }
        }
        System.out.println();
    }
}