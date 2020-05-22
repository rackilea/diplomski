for (Field field : Ideone.class.getDeclaredFields()) {
        Type type = field.getGenericType();
        if (type instanceof ParameterizedType) {
            ParameterizedType ptype = (ParameterizedType) type;
            if (ptype.getRawType() == ScheduledView.class) {
                if (ptype.getActualTypeArguments().length == 1
                    && ptype.getActualTypeArguments()[0] == WantedClass.class) {
                  // Do whatever with the field.
                  System.out.println(field.getName());
                }
            }
        }
    }