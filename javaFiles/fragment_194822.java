import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class LexerTest 
{
    private StringReader r;

    public LexerTest(StringReader stringReader) {
        r = stringReader;
    }

    public static void main(String[] args) throws IOException 
    {
        String s = "test = test1 + (test2 * test3 * (test4 - 2);";
        new LexerTest(new StringReader(s)).printTokens();

        System.out.println("\n### Test 2 ###\n");
        s = "test = if(test1 < test2){ test3 = (test4 - 2);}";
        new LexerTest(new StringReader(s)).printTokens();

        System.out.println("\n### Test 3 ###\n");
        s = "test = if(test1 <= test2){ test3 = (test4 - 2);}";
        new LexerTest(new StringReader(s)).printTokens();

        System.out.println("\n### Test 4 ###\n");
        s = "test = if(test1 < test2){ test3 = (test4 << 2);}";
        new LexerTest(new StringReader(s)).printTokens();
    }

    private void printTokens() throws IOException 
    {
        StreamTokenizer st = new StreamTokenizer(r);
        st.eolIsSignificant(true);

        int token = st.nextToken();
        while (token != StreamTokenizer.TT_EOF) 
        {
            token = st.nextToken();
            switch (token) 
            {
            case StreamTokenizer.TT_NUMBER:
                double num = st.nval;
                System.out.println("Number found: " + num);
                break;
            case StreamTokenizer.TT_WORD:
                String word = st.sval;
                System.out.println("Word found: " + word);
                break;
            case '+':
                break;
            case '-':
                break;
            case '/':
                break;
            case '*':
                break;
            case '<':
            {
                int t = st.nextToken();
                switch(t)
                {
                case '=':
                    System.out.println("<=");
                    break;
                case '<':
                    System.out.println("<<");
                    break;
                    default:
                        st.pushBack();
                        System.out.println("<");
                        break;
                }
            }
            }
        }

    }
}