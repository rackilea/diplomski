@Entity
public class Person {
    @Id
    private int id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private OtherInfo otherInfo;

    rest of attributes ...
}