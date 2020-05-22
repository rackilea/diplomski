public class Main {
    public static void main(String[] args) {
        Type type = new TypeToken<HashMap<String,Stack<Person>>>(){}.getType();
        Gson gson = new Gson();
        HashMap<String,Stack<Person>> map = new HashMap<String, Stack<Person>>();
        map.put("yair", new Stack<Person>());
        map.get("yair").add(new Person("Yair",36));
        String str = gson.toJson(map,type);
        System.out.println(str);
        map = gson.fromJson(str,type);
        String str2 = gson.toJson(map,type);
        System.out.println(str2);

    }
}