public String toFormParams(List<?> items, Class clazz) {

    String name = clazz.getSimpleName();
    // Find public/private members
    Field[] fields = clazz.getDeclaredFields();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < items.size(); i++) {
        Object item = items.get(i)

        for (int f = 0; f < fields.length; f++) {
            Field field = fields[f];
            // ensure private members can be accessed
            field.setAccessible(true);

            sb.append(name);
            sb.append("[" + i + "]");
            sb.append("[" + field.getName() + "]");
            sb.append("=" + field.get(item));
            sb.append("\n");
        }
    }

    // Remove last \n and return
    return sb.deleteCharAt(sb.length() - 1).toString();
}