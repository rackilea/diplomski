public static <T extends Entity> T parseFromJSON(File file, Class<T> clazz) {
    return clazz.cast(gson.FromJson(new FileReader(file), clazz));
}

public static <T extends Entity> T[] parseFromJSONArray(File file, Class<T[]> clazz) {
    return clazz.cast(gson.FromJson(new FileReader(file), clazz));
}