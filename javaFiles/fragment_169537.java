/**
 * Interface to allow plugins to contribute resource reference properties.
 */
public interface IResourcePropertyLoader {
    /**
     * Retrieve the base name for the additional text resource.
     * @return
     */
    String getResourcePropertyBaseName();
}