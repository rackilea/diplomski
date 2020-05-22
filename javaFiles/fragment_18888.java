loader.setControllerFactory(ic -> {
    try {
        for (Constructor<?> c : ic.getConstructors()) {
            if (c.getParameterCount() == 1 && c.getParameterTypes()[0]==Model.class) {
                return c.newInstance(m);
            }
        }
        return ic.newInstance();
    } catch (Exception e) {
        // fatal...
        throw new RuntimeException(e);
    }
});