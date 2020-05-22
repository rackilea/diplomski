public static void main(String[] args)
{
    int sum = 0;
    for (int i = 0; i < args.length; i++)
    {
        String digitsOnly = args[i].replaceAll("[^0-9]", "");
        if (digitsOnly.length() != 0)
            sum += Integer.parseInt(digitsOnly);
    }
    System.out.println(Arrays.toString(args));
    System.out.println(sum);
}