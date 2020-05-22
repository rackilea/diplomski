import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class LineReaders2 
{
    private LineReaders2() {}

    static class FileLineReader implements LineReader2 
    {
        final private BufferedReader br;

        public FileLineReader(Reader in)
        {
            this.br = new BufferedReader(in);
        }
        @Override public void close() throws IOException {
            this.br.close();
        }
        @Override public String readLine() throws IOException {
            return this.br.readLine();
        }       
    }

    static class StringIteratorReader implements LineReader2
    {
        final private Iterator<String> it;

        public StringIteratorReader(Iterator<String> it) {
            this.it = it;
        }
        @Override public void close() {}
        @Override public String readLine() {
            return this.it.hasNext() ? this.it.next() : null;
        }       
    }

    static public LineReader2 createReader(File f) throws IOException
    {
        return new FileLineReader(new FileReader(f));
    }
    static public LineReader2 createReader(Iterable<String> iterable)
    {
        return new StringIteratorReader(iterable.iterator());
    }
    static public LineReader2 createReader(Iterator<String> iterator)
    {
        return new StringIteratorReader(iterator);
    }
}