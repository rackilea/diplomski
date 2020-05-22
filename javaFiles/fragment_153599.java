String lineSeparator = java.security.AccessController.doPrivileged(
    new java.security.PrivilegedAction<String>() {
        public String run() {
            return System.getProperty("line.separator");
        }
    }
 );