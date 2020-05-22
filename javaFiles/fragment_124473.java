@Service
public class ModelService {

  private final RestTemplate restTemplate;

  public ModelService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Cacheable(value = "model", key = "#root.methodName")
  public Model getModel() {

    MetadataReader metadataReader = new MetadataReader();
    String prismFormatJson = null;
    if (!isHasLatestTransformedJson()) {
        prismFormatJson = metadataReader.transformToPrismJson(restTemplate, environment);
        setLastGoodPrismConfiguration(prismFormatJson);
    } else {
        prismFormatJson = getLastGoodPrismConfiguration();
    }
    if (model != null) {
        return model;
    } else {
        return metadataReader.createModelForPrism(prismFormatJson);
    }
  }

  //... the rest of the code
}