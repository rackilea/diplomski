import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class FeatureList {

  private List<Feature> features;

  @XmlElement(name = "Feature")
  public List<Feature> getFeatures() {
    return features;
  }

  public void setFeatures(List<Feature> features) {
    this.features = features;
  }
}