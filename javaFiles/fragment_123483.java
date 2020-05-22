public static Charset defaultCharset() {
    if (defaultCharset == null) {
        synchronized (Charset.class) {
            java.security.PrivilegedAction pa =
                    new GetPropertyAction("file.encoding");
            String csn = (String) AccessController.doPrivileged(pa);
            Charset cs = lookup(csn);
            if (cs != null)
                defaultCharset = cs;
            else
                defaultCharset = forName("UTF-8");
        }
    }
    return defaultCharset;
}