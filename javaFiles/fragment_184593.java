/**
 * Pseudo URL prefix for all matching resources from the class path: "classpath*:"
 * This differs from ResourceLoader's classpath URL prefix in that it
 * retrieves all matching resources for a given name (e.g. "/beans.xml"),
 * for example in the root of all deployed JAR files.
 * @see org.springframework.core.io.ResourceLoader#CLASSPATH_URL_PREFIX
 */
String CLASSPATH_ALL_URL_PREFIX = "classpath*:";