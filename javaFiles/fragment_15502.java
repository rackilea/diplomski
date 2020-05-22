public final class Config {
    public static final String A1;
    public static final String A2;
    ...
    public static final String AN;

    static
    {
        Properties props = new Properties ();
        try
        {
            props.load (new FileInputStream (System.getProperty ("config.file")));
        }
        catch (IOException ex)
        {
            throw new RuntimeException (ex);
        }
        A1 = props.getProperty ("A1");
        A2 = props.getProperty ("A2");
        ...
        AN = props.getProperty ("AN");
    }
}