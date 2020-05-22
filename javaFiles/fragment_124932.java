@Component
@ConfigurationProperties(prefix="features")
public class ConstantProperties {
    private String feature1;

    public String getFeature1(){
        return feature1;
    }
    public void setFeature1(String feature1) {
        this.feature1 = feature1;
    }
}