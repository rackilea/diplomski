public class Entity {
    private long id;
    private String description;

    @JsonDeserialize(using = MyDes.class)
    private ContainedObject containedObject;

   //Contructor, getters and setters omitted

 }