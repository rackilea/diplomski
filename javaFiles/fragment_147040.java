public static void main(String[] args)
{
    double[] alpha = initialize();

    print(alpha);        

}

private static double[] initialize() {

    double[] alpha = new double[50];

    for(int i=0; i<alpha.length; i++)
    {
        alpha[i] = Math.pow(1,2);
        System.out.println("Alpha[" + i + "]: " + alpha[i]);

        if(i < 25)
        {
            alpha[i] = Math.pow(1,2);
            System.out.println("Alpha[" + i + "]: " + alpha[i]);
        }
        else
        {
            alpha[i] = i*3;
            System.out.println("Alpha[" + i + "]: " + alpha[i]);
        }
    }
    return alpha;
}

public static void print(double[] alpha) {
    for(int i=0; i<alpha.length; i++)
    {
        System.out.print(alpha[i] + " ");
        if ((i+ 1)%10 == 0)
            System.out.println();
    }
}