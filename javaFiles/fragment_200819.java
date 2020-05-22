public class IdsListConverter {

    @TypeConverter
    public List<Long> idsFromString(String value) {
        Gson gson = new Gson();
        if (value == null || value.isEmpty()) {
            return null;
        } else {
            Type resultType = new TypeToken<List<Integer>>(){}.getType();
            return gson.fromJson(value, resultType);
        }
    }

    @TypeConverter
    public String idsToString(List<Long> ids) {
        if (ids == null) {
            return null;
        } else {
            Gson gson = new Gson();
            return gson.toJson(ids);
        }
    }

}