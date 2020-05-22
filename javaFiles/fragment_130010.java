public interface MapSerializable {

    public static String CLASS_KEY = "MapSerializable.CLASS_KEY";

/**
 * Object will populate a HashMap of objects that it can use at some later
 * point to reinitialize itself. Return the hash of the objects used to
 * build itself.
 *
 * @param serial
 * @return
 * @throws IOException
 */
    public int populateSerialMap(HashMap<String, Object> serial) throws IOException;

/**
 * Object will initialize itself using the input HashMap. Returns the hash
 * of the objects that were used to initialize itself from the Map.
 *
 * @param serial
 * @return hash of the objects that were used to load yourself.
 * @throws IOException
 */
    public int initializeFromMap(HashMap<String, Object> serial) throws IOException;

}