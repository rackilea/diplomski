import java.io.Reader;

private void loadProperties()
{
    InputStream en_is = null;
    InputStream fr_is = null;
    try {
        this.en_prop = new Properties();
        this.fr_prop = new Properties();
        en_is = this.getClass().getResourceAsStream(en_path);
        fr_is = this.getClass().getResourceAsStream(fr_path);

        Reader reader = new InputStreamReader(fr_is, "UTF-8");

        en_prop.load(en_is);
        fr_prop.load(reader);
        reader.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}