import java.io.*;

public class FindWord
{
  public static void main(String[] args)
  {
    String searchWord = "Hello";

    try (BufferedReader in = new BufferedReader(
            new FileReader("D:\\Downloads\\dataAnalysis1.txt"));
         BufferedWriter out = new BufferedWriter(
             new FileWriter("D:\\Downloads\\output.txt")))
    {
      String line;
      while ((line = in.readLine()) != null)
      {
        System.out.println(line);

        // extract by lines and write to file
        String firstColumn =  line.split(",")[0];
        if (firstColumn.contains(searchWord))
        {
          out.write(line);
          out.newLine();
        }
      }
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
  }
}