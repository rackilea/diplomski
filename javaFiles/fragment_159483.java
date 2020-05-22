public static void main( String[] args )
{
    Scanner in = new Scanner(System.in) ;
    System.out.print("Please enter the height of H: ") ;
    int height = in.nextInt() ;
    int heightThird = findThird(height);
    for (int i = 0; i < heightThird; i++) {
        printTopAndBottom(heightThird);
    }
}

public static int findThird(int height3)
{
    if(height3 >= 4)
    {
        height3 = (height3 + 2) / 3 ;
    }
    return height3 ;
}

public static void printTopAndBottom(int spacingH)
{
    String line = "";

    for (int j = 0; j < spacingH; j++) {
        String currentChar = j % 2 == 0 ? "h" : " ";
        for (int i = 0; i < spacingH; i++) {
            line += currentChar;
        }
    }

    System.out.print(line + "\n");
}