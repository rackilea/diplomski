@Component
public class Configuration {

    private static String imagePath;

    @Value("${project.image.path}")
    public void setImagePath(String value) {
        this.imagePath = value;
    }
}