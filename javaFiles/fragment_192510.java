public class Simple {

    public static void main(String[] arg) {
        Set<Long> regionsSet = new LinkedHashSet<>();
        regionsSet.add(1l);
        regionsSet.add(2l);
        Gson gson = new Gson();
        JsonArray jr = new JsonArray();
        jr.add(1);
        jr.add(2);
        System.out.println("Not Equal now : " + jr.equals(gson.toJson(regionsSet).toString()));
        System.out.println("Equal now :  " + jr.toString().equals(gson.toJson(regionsSet).toString()));
    }
}