//CustomBootstrapCacheLoader implements BootstrapCacheLoader


        List<?> keys = cache.getKeys();

        if ((keys == null) || keys.isEmpty())
        {
            return;
        }

        for (Object key : keys)
        {
           Element el = cache.getQuiet(key);
           cache.removeQuiet(key);
           cache.putQuiet(el);
        }