public static StringBuilder seekFieldsWithAnnotations(Object object) {
    Class<?> c = object.getClass();

    StringBuilder sb = new StringBuilder();

    Field[] fieldsArr = c.getDeclaredFields();
    List<Field> allFields = new ArrayList<>(Arrays.asList(fieldsArr));

    for(Field field : allFields) {
        if(field.getDeclaredAnnotations().length > 0) {
            Annotation[] fieldAnnots = field.getDeclaredAnnotations();

            sb.append("Field Name: " + field.getName() + "\nAnnotations: ");
            for(int i = 0; i < fieldAnnots.length; i++) {
                if(fieldAnnots.length == 1 || fieldAnnots.length - i == 1) {
                    sb.append(fieldAnnots[i].toString() + "\n\n");
                } else {
                    sb.append(fieldAnnots[i].toString() + ", ");
                }
            }
        } else {
            System.out.println("\"" + field.getName() + "\" has no annotations.\n");
        }
    }
    return sb;
}