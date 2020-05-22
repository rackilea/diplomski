package main;

    import java.io.File;
    import java.io.FileInputStream;
    import java.util.Properties;

    public class PopertiesFileSeemsToBeProducingANullPointerException {

        private static String testEnvironment;
        private static final String CONFIG_PROPERTIES_DIRECTORY = "src/main/resources/envs.properties";

        //GLOBAL URL's
        public static String HOMEPAGE_URL = "https://" + testEnvironment + ".deltaway.co.uk/";

        static {
            try{
                Properties props = new Properties();
                File file = new File(PopertiesFileSeemsToBeProducingANullPointerException.CONFIG_PROPERTIES_DIRECTORY);
                FileInputStream fileInput = new FileInputStream(file);
                props.load(fileInput);

                // process properties content
                testEnvironment = props.getProperty("testEnvironment");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        public static void main(String[] args) {
            System.out.println(testEnvironment);

        }

    }