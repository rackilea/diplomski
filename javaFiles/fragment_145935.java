/**
 * Returns the data. The returned list is unmodifiable. 
 */
List<String> getData() {
    return Collections.unmodifiableList(internalData);
}