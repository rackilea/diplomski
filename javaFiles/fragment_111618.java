@DiscriminatorFormula("case when age is null then 0 else age end")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name="person_id")
    private int personId;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private Integer age;
}