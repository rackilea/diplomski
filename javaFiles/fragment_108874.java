public static void printSquare(int sideLength) 
{
    for (int i = 0; i < sideLength; i++) {
        for (int j = 0; j < sideLength; j++) {
            System.out.print("[]");
        }
        System.out.println();
    }
}