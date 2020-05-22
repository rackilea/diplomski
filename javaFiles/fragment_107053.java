/**
 * Defines JUnit Jupiter API for writing tests.
 */
module org.junit.jupiter.api {
    requires transitive org.apiguardian.api;
    requires transitive org.junit.platform.commons;
    requires transitive org.opentest4j;

    exports org.junit.jupiter.api;
...
}