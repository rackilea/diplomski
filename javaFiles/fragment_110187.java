@Entity
@Table("entities)
public class MyEntity {

     @ID
     private String name;
     @Column(name="age")
     private int age;
     @JsonView(View.Private.class)
     @Column(name="weight")
     private int weight;

     ...getters and setters..

}