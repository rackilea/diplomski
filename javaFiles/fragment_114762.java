import java.util.Properties;

public final class Main {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.load(Main.class.getResourceAsStream("/junk.properties"));
        System.out.println(props.getProperty("timestamp"));
    }
}