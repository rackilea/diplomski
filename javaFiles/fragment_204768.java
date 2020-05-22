public class CustomJsonFormatter extends JacksonJsonFormatter{

    @Override
    public String toJsonString(Map map) throws IOException {
        map.put("severity", map.get("level"));
        map.remove("level");
        return super.toJsonString(map);
    }
}