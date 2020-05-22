@Configuration
public static Option[] config() {
    return options(
            junitBundles(),

            /* PAX Logging */
            mavenBundle("org.ops4j.pax.logging", "pax-logging-api", "1.7.2"),
            mavenBundle("org.ops4j.pax.logging", "pax-logging-service", "1.7.2"),

            /* Apache Felix Config Admin */
            mavenBundle("org.apache.felix", "org.apache.felix.configadmin", "1.8.0"),

            ConfigurationAdminOptions.newConfiguration("my.pid")
                .put("prop1", "value1")
                .put("prop2", "value2")
                .asOption(),

            /* Eclipse Gemini + dependencies */
            mavenBundle().groupId("org.aopalliance").artifactId("com.springsource.org.aopalliance").versionAsInProject(),
            mavenBundle().groupId("org.springframework").artifactId("org.springframework.aop").versionAsInProject(),
            mavenBundle().groupId("org.springframework").artifactId("org.springframework.beans").versionAsInProject(),
            mavenBundle().groupId("org.springframework").artifactId("org.springframework.context").versionAsInProject(),
            mavenBundle().groupId("org.springframework").artifactId("org.springframework.core").versionAsInProject(),
            mavenBundle("org.eclipse.gemini.blueprint", "gemini-blueprint-core", GEMINI_VERSION),
            mavenBundle("org.eclipse.gemini.blueprint", "gemini-blueprint-extender", GEMINI_VERSION),
            mavenBundle("org.eclipse.gemini.blueprint", "gemini-blueprint-io", GEMINI_VERSION),

            /* Other bundles */
            );
}