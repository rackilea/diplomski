static void Main(string[] args)
    {
        double[][] A = new double[2][] { new double[2], new double[2] };
        A[0][0] = 1.5;
        A[0][1] = 2.5;
        A[1][0] = 3.5;
        A[1][1] = 4.5;
        System.Console.WriteLine(A[0][0]);
        // Prints 1,5
        Console.Read();
        double[] B = A[0];
        System.Console.WriteLine(B[0]);
        // Prints 1,5
        System.Console.Read();
        System.Console.Read();

    }