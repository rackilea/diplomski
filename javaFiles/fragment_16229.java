public static class SerialReader implements Runnable 
{   //Final frame = new Final();

    InputStream in;
    private JLabel label;

    public SerialReader ( InputStream in, JLabel label ) {
         this.label = label;
         //...