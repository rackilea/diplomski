public class textWriter{
    private Context m_context;

    public textWriter(Context ctx) {
        m_context = ctx;
    }    
    public void write(String name, String something) {

        try {
            FileOutputStream output;
            output = m_context.openFileOutput(name,MODE_APPEND);
            PrintStream prt;
            prt = new PrintStream(output);
            prt.println(something);
            prt.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}