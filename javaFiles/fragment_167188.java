@SwaggerDefinition
public class SwaggerBasePathModifier implements ReaderListener {

  @Override
  public void beforeScan(Reader aReader, Swagger aSwagger) {
    // do nothing
  }

  @Override
  public void afterScan(Reader aReader, Swagger aSwagger) {
    final Map<String, Path> newSwaggerPaths = new HashMap<>();
    final String applicationPath = DocsConfig.class.getAnnotation(ApplicationPath.class).value();
    for (final Map.Entry<String, Path> entry : aSwagger.getPaths().entrySet()) {
      final currKey = entry.getKey().substring("/api".length(), entry.getKey().length())
      final String newKey = "/api" + applicationPath + currKey;
      newSwaggerPaths.put(newKey, entry.getValue());
    }
    aSwagger.setPaths(newSwaggerPaths);
  }
}