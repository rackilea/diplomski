import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class Test {

  public static void main(String[] args) {
    File file =
        new File("E:\\so\\xml\\minxml.xml");
    JAXBContext jaxbContext;

    try {
  jaxbContext = JAXBContext.newInstance(InteriorResponse.class);
  Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
  InteriorResponse interiorFeatures = (InteriorResponse) unmarshaller.unmarshal(file);

  List<Feature> list_feat = interiorFeatures.getFeatureList().getFeatures();

  List<String> optionList = interiorFeatures.getOptionList().getOption();
  for (String option : optionList) {
    System.out.println("Option Value : " + option);
  }

  for (Feature ft : list_feat) {
    System.out.println(ft.getCode());
  }
} catch (JAXBException e) {
  e.printStackTrace();
}
  }
}