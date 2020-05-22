for (Class<?> c = someClass; c != null; c = c.getSuperclass())
    {
        Field[] fields = c.getDeclaredFields();
        for (Field classField : fields)
        {
            result.add(classField);
        }
    }