public class Main {
    public static void main(String[] args) {
        String json = "{\r\n"
                + "   \"name\": \"abc\",\r\n"
                + "   \"add\": \"random\",\r\n"
                + "   \"skills\": {\r\n"
                + "     \"java\": {\r\n"
                + "       \"subCategory\": \"soft\",\r\n"
                + "       \"proficiency\": \"A\"\r\n"
                + "     },\r\n"
                + "    \"C#\": {\r\n"
                + "       \"subCategory\": \"soft\",\r\n"
                + "       \"proficiency\": \"B\"\r\n"
                + "     }\r\n"
                + "  }\r\n"
                + "}";

        Info info = new Gson().fromJson(json, Info.class);
        System.out.println(info.getSkills());
    }

}

class Info {
    private String name;
    private String add;
    private Map<String, Skill> skills;

    public String getName() {
        return this.name;
    }

    public String getAdd() {
        return this.add;
    }

    public Map<String, Skill> getSkills() {
        return this.skills;
    }
}

class Skill {
    String subCategory;
    String proficiency;
}