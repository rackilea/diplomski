Enumeration bundleKeys = labels.getKeys();

    while (bundleKeys.hasMoreElements()) {
        String key = (String)bundleKeys.nextElement();
        String value = labels.getString(key);
        System.out.println("key = " + key + ", " + 
                   "value = " + value);
    }