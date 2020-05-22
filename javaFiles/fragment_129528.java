/**
 * Write an object
 * 
 * @param source
 *            at object (bean instance) whose values to extract
 * @param nameMapping
 *            defines the fields of the class that must be written. 
 *            null values are not allowed
 * @since 1.0
 */
public void write(Object source, String... nameMapping) throws IOException,
    SuperCSVReflectionException;