public static <T extend MyParentEntity> List<T> getFavList(
    Context context, Class<T> clazz, T key
) {

    String prefKey = buildKey(key);
    List<T> entityList = new ArrayList<T>();

    SharedPreferences settings = context.getSharedPreferences(prefKey, 0);

    GSON gson = new GSON();
    MyEntity entity = gson.fromJson(settings.getString(0, null), clazz);

    entityList.add(entity);

    return entityList;
}