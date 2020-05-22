private Node createNode(Document document, Object object) {
    ..
    List<Field> fields = Lists.newArrayList(object.getClass().getFields());
        for(Field field: fields) {
        ...
        Object obj = field.get(object);
        ...
        else if(field.getType().isArray()) {
            Object array = field.get(obj); //Fails here