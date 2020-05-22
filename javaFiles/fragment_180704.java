public class Main {
    public static void main(String[] args) {
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Person person = g.fromJson("{\"name\":\"Jhon\",\"lastName\":\"Smith\",\"clothes\":{\"gender\":\"male\",\"Shirt\":{\"id\":113608,\"name\":\"Green Shirt\",\"size\":\"Large\"},\"Pants\":{\"id\":115801,\"name\":\"Black Leather Pants\",\"size\":\"Large\"}}}", Person.class);
        System.out.println(person.getClothes());
        System.out.println(person.getGender());
    }
}