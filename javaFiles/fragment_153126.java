public class SkipLineBufferedReader extends BufferedReader
{

    public SkipLineBufferedReader(Reader in) 
    {
        super(in);
    }

    public SkipLineBufferedReader(Reader in, int sz) 
    {
        super(in, sz);
    }

    //Return \n or -1 if EOF
    public int skipLine() throws IOException
    {
        int ch;
        do
        {
            ch = read();
        }
        while (ch != -1 && ch != '\n');

        return ch;
    }
}