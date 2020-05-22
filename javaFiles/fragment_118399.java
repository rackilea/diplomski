int nR;
int nC;

public static void main(String[] args)
{
    // Convert the String into its corresponding integer
    //by calling one of the methods of the integer wrapper class
    int xnR = Integer.parseInt(args[0]);
    int xnC = Integer.parseInt(args[1]);
    System.out.println("The rows are: " +xnR);
    System.out.println("The columns are: " +xnC);

    W1Graphics w = new W1Graphics(xnR, xnC);
    w.setVisible(true);
}

public W1Graphics(int nR, int nC)
{
    this.nR = nR;
    this.nC = nC;