public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        final String json = gson.toJson(new Group());

        System.out.println(json);

        Group g = gson.fromJson(json, Group.class);
        System.out.println(g);
    }

    public static class Group {
        Double val;
        Integer num;
        Section sectionObj;
       // Getters and setters...

        @Override
        public String toString() {
            return "val: '" + val + "' num: '" + num
                    + "' sectionObj: '" + sectionObj + "'";
        }
    }

    public static class Section {}
}