public static void main(final String[] args)
        throws FileNotFoundException
{
    final File file = new File("C:\\textstr.txt");
    final Scanner fileRead = new Scanner(file);
    int lineCount = 0;
    int i = 0;

    while (fileRead.hasNextLine())
    {
        lineCount++;
        i = lineCount % 2;
        final String str = fileRead.nextLine();
        if (i == 1)
        {
            System.out.println("Line count -- >> " + lineCount);
            System.out.println(str);
        }
    }
    fileRead.close();
}