ReflectionUtils.doWithFields(bean.getClass(), 
    new FieldCallback() {
        public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
            GenerateRandomInt annotation = field.getAnnotation(GenerateRandomInt.class);
            int min = annotation.min();
            int max = annotation.max();
            int i = random.nextInt(max-min);
            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(bean, field, i);
        }

    }, 
    new FieldFilter() {
        public boolean matches(Field field) {
            return field.getAnnotation(GenerateRandomInt.class) != null;
        }
    });