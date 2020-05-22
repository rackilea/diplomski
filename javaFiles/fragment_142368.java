import java.net.URL;
public class SampleLoad {
    public static void main(String[] args) {
        final URL resource = SampleLoad.class.getResource("SampleLoad.class");
        System.out.println(resource);
    }
}