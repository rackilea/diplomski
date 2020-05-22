@Entity
@Table(name = "PERSON", schema = "public")
public class Person {
    @Id private long id;
    private String name;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="food_ref_id")
    private FoodRef favoriteFood;

    private Address address;

    //Getters, Setter etc.....
}