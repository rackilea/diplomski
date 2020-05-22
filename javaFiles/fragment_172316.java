import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;


public class TokenTeaser
{
  public static void main(String[] args)
  {
    try
    {
      String testString = "one two, three, four five";
      StringReader sr = new StringReader(testString);
      StreamTokenizer st = new StreamTokenizer(sr);
      st.whitespaceChars(',', ',');
      st.wordChars(' ', ' ');
      int currentToken = st.nextToken();
      while (currentToken != StreamTokenizer.TT_EOF)
      {
        System.out.println(st.sval);
        currentToken = st.nextToken();
      }
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}