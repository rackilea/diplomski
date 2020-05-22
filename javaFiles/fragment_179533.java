public class CommandBuilder {
    public void setPrefix(); // e.g. cmd or /bin/sh But some kind of automatic logic should be implemented too, i.e. cmd for windows, /bin/sh for unix
    public void setCommand(); // for example ping
    public void addArgument(String value);  // e.g. myhost
    public void setInputStream(InputStream in);
    public void setOutputStream(OutputStream in);

    // add appropriate getters.

    public Process exec();
    public int execAndWait(); // returns process status
}