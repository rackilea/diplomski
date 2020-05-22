public static void main(String[] args)
{
    int numOne; int numTwo;
    Scanner input= new java.util.Scanner(System.in);
    //Get First value
    System.out.println("First number:");
    numOne = input.nextInt();
    //Get Second value
    System.out.println("Second number:");
    numTwo=input.nextInt();
    input.close();
    int x=1;
    int y=1;
    System.out.print("     ");
    while(x<=numOne)
    {
        System.out.print(" [  x="+ x +" ] ");
        x++;
    }

    x=1;y=1;
    while(y<=numTwo)
    {
        System.out.println();
        System.out.print("[y="+ y +"]");
        while(x<=numOne)
        {
            int tResult=x%y;
            System.out.print(" [("+ x +"%"+ y +")"+tResult+"] ");
            x++;
        }
        y++;
        x=1;
    }
}