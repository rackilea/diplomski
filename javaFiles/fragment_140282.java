public static void exportObjectToExcel(final Object obj) {
    try {
        for (final Field field : obj.getClass().getDeclaredFields()) {
            try {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                Object value = field.get(obj);
                System.out.println("variable: \"" + field.getName() + "\", value: \"" + value + '"');
                //TODO Excel code here (e.g. Apache POI or JXL)
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } catch (final Exception e) {
        e.printStackTrace();
    }
}