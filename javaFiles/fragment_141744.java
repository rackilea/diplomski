Field[] fields = getClass().getDeclaredFields();
    for (Field field : fields) {
        if (field.getType().equals(EntityManager.class)) {
            EntityManager em = (EntityManager) field.get(this);
            // do something with em
        }
    }