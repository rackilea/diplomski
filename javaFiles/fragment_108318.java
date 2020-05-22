@Entity
public class TestEntity {

    @Column
    @NotNull
    @Convert(converter = SexConverter.class)
    private Sex sex;
}