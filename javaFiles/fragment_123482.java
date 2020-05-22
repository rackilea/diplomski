public static Charset defaultCharset() {
    synchronized (Charset.class) {
        if (defaultCharset == null) {
            java.security.PrivilegedAction pa =
                    new GetPropertyAction("file.encoding");
            String csn = (String) AccessController.doPrivileged(pa);
            Charset cs = lookup(csn);
            if (cs != null)
                return cs;
            return forName("UTF-8");
        }
        return defaultCharset;
    }
}