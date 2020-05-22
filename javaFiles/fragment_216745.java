public class Entity {
    private String title;
    private String text;
    //getters and setters...
}

List<Entity> entityList = new ArrayList<>();
for (int i = 0; i < 10; i++) {
    Entity entity = new Entity();
    entity.setTitle("title" + i);
    entityList.add(entity);
}