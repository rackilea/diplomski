public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);



        System.out.println("Enter a floating point number");

        float nA= input.nextFloat();
        double nB= Math.pow(nA, 3.5);

        System.out.println("nB = nA^3.5" +nB);


    }