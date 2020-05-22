/**
 * This method provides a convenient means of determining the JSF
 * Specification version.
 *
 * @return JSF Specification version, e.g. 2.1
 * @since 1.5
 */
public static String getSpecificationVersion() {
    return FacesContext.getCurrentInstance().getClass().getPackage().getSpecificationVersion();
}

/**
 * This method provides a convenient means of determining the JSF
 * Implementation version.
 *
 * @return JSF Implementation version, e.g. 2.1.26
 * @since 1.5
 */
public static String getImplementationVersion() {
    return FacesContext.getCurrentInstance().getClass().getPackage().getImplementationVersion();
}

/**
 * This method provides a convenient means of determining the JSF
 * Implementation Title.
 *
 * @return JSF implementation title, e.g. Mojarra.
 * @since 1.5
 */
public static String getImplementationTitle() {
    return FacesContext.getCurrentInstance().getClass().getPackage().getImplementationTitle();
}