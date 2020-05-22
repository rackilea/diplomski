/**  
 * Convert a Java Color to equivalent HTML Color.
 *
 * @param color The Java Color
 * @return The String containing HTML Color.
 */
public static String getHTMLColor(Color color) {
    if (color == null) {
        return "#000000";
    }
    return "#" + Integer.toHexString(color.getRGB()).substring(2).toUpperCase();
}