Field secretField = URLClassLoader.class.getDeclaredField("ucp");
        secretField.setAccessible(true);
        Object ucp = secretField.get(loader);
        secretField = ucp.getClass().getDeclaredField("lmap");
        secretField.setAccessible(true);
        return secretField.get(ucp);