public static void  main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    System.out.print("Input int1: ");
    char[] firstInteger = sc.nextLine().toCharArray();
    System.out.print("Input int2: ");   
    char[] secondInteger = sc.nextLine().toCharArray();

    int[] num1 = char2Integer(firstInteger);
    int[] num2 = char2Integer(secondInteger);

    sum2(reverse(num1), reverse(num2)); //different length, assumed num1 is bigger
}

public static void sum2(int[] num1, int[] num2)
{
    //int over = num1.length-num2.length;
    int[] sum = new int[num1.length+1];
    //The pad function pads the array with 0 so there are no out of range exceptions
    num1 = pad(num1, sum.length);
    num2 = pad(num2, sum.length);

    for (int i = 0;  i < num1.length; i++)
    {
        sum[i] = sum[i] + num1[i] + num2[i];

        //if an element exceeds a value of 10
        if (sum[i] >= 10)
        {
            sum[i] = sum[i]%10;
            sum[i+1]++;
        }
    }
    sum = reverse(sum);
    for (int i = 0; i < sum.length; i++)
        System.out.print(sum[i]);
}