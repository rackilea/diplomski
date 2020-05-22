public static void readNumbers()
{

    File inputFile = new File ("C:/users/AC/Desktop/input.txt");
    try {
        Scanner reader = new Scanner(inputFile);
        while(reader.hasNext())
        {
            try
            {
                int num = reader.nextInt();
                System.out.println("Number read: " +num);
            }
            catch (InputMismatchException e)
            {
                System.out.println("Input error ");
                reader.next();   // THIS LINE IS NEW
            }
        }
    }
    catch (FileNotFoundException e2)
    {
        System.out.println("File not found!");  
    }

}