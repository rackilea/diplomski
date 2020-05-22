/**
 * A key for location URL in namespace map.
 * @see #getNamespace()
 * @since JavaFX 2.2
 */
public static final String LOCATION_KEY = "location";
/**
 * A key for ResourceBundle in namespace map.
 * @see #getNamespace()
 * @since JavaFX 2.2
 */
public static final String RESOURCES_KEY = "resources";

private URL location;
private ResourceBundle resources;

private <T> T loadImpl(InputStream inputStream,
                       Class<?> callerClass) throws IOException {
    ...
    namespace.put(LOCATION_KEY, location);
    namespace.put(RESOURCES_KEY, resources);
    ...
}