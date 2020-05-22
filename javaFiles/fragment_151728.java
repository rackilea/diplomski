Cipher.getMaxAllowedKeyLength("AES"); // Will return 128 in "limited" mode; Integer.MAX_VALUE in "unlimited"

System.getenv("JAVA_HOME"); // Gets the Java home path as set in the OS environment -- in this case should be /usr/lib/jvm/java-8-oracle/
System.getProperty("java.home"); // Gets the JRE home path -- in this case should be /usr/lib/jvm/java-8-oracle/jre

System.getenv("PATH"); // Gets the current PATH variable from the OS environment
System.getProperty("java.class.path"); // Gets the Java classpath

System.getProperty("java.version"); // Gets the JRE version number of the current JVM