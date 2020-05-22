// Call this method to get the list of fields.
public static List<String> getAllFields(Class<?> clazz) {
    List<String> results = new ArrayList<String>();
    getFieldDescsForClass(clazz, results);
    return results;
}

private static void getFieldDescsForClass(Class<?> clazz, List<String> outList) {
    // Loop over all the fields and add the info for each field
    for (Field field : clazz.getDeclaredFields()) {
        // Ignore synthetic fields
        if (!field.isSynthetic()) {
            outList.add(String.format("User Preferences %s - %s", field.getName(), field.getType()));
        }
    }

    // For any internal classes, recursively call this method and add the results
    // (which will in turn do this for all of that subclass's subclasses)
    for (Class subclazz : clazz.getDeclaredClasses()) {
        getFieldDescsForClass(subclazz, outList);
    }
}