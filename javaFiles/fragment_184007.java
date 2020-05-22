/**
 * Allow Map access to the JavaMail properties of this sender,
 * with the option to add or override specific entries.
 * <p>Useful for specifying entries directly, for example via
 * "javaMailProperties[mail.smtp.auth]".
 */
public Properties getJavaMailProperties() {
    return this.javaMailProperties;
}