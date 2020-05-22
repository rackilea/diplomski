@Entity
public enum MyEnum{
    @EnumValue
    private String name;
    @Id
    private int id;
}
@Entity
public class MyEntity {
    @EnumReference
    protected MyEnum myEnum;
}