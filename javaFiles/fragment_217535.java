public class TestGetResource
{
    public static void main(String[] args) throws Exception
    {
        URL url = TestGetResource.class.getResource("/resource/wortliste.txt");
        System.out.println("URL: " + url);
        File f = new File(url.getFile());
        System.out.println("File: " + f);
        System.out.println("File exists: " + f.exists());

        try {
            FileReader reader = new FileReader(f);        
            reader.read();
        } catch (FileNotFoundException notFoundEx) {
            System.out.println("Caught FileNotFoundException: " + notFoundEx.getMessage());
        }
    }

}