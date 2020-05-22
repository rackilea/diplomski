/**
 * Sets a metadata value in the implementing object's metadata store.
 *
 * @param metadataKey A unique key to identify this metadata.
 * @param newMetadataValue The metadata value to apply.
 * @throws IllegalArgumentException If value is null, or the owning plugin
 *     is null
 */
public void setMetadata(String metadataKey, MetadataValue newMetadataValue);