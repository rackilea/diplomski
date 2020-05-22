public class prog402a
{

    public static void main (String [] args)
    {
        Scanner inFile = null;
        try 
        {
            // Create a scanner to read the file, file name is parameter
            inFile = new Scanner (new File("prg402a.dat.txt"));
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println ("File not found!");
            // Stop program if no file found
            System.exit (0);
        }

        int[] ids = new int[100];
        int[] scores = new int[100];
        int count = 0;

        while (inFile.hasNextInt())
        {
            ids[count] = inFile.nextInt();
            scores[count] = inFile.nextInt();
            count++;
        }
        for (int index = 0; index < count; index++)
        {
            System.out.println(ids[index] + " " + scores[index]);
        }
    }
}