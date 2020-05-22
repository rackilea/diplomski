// MimeTypes.java:155
        ResourceBundle encoding = ResourceBundle.getBundle("org/eclipse/jetty/http/encoding");
        Enumeration<String> i = encoding.getKeys();
        while(i.hasMoreElements())
        {
            String type = i.nextElement();
            __encodings.put(type,encoding.getString(type));
        }