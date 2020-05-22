static void setAccessible(final AccessibleObject ao,
                          final boolean accessible) {
    if (System.getSecurityManager() == null)
        ao.setAccessible(accessible); // <~ Dragons
    else {
        AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                ao.setAccessible(accessible);  // <~ moar Dragons
                return null;
            }
        });
    }
}