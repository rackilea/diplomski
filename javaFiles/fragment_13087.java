@MappedSuperclass
public abstract class MyAbstractProperty<T extends Object>{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    public abstract T getDefaultValue();
}

@Entity
class MyStringProperty extends MyAbstractProperty<String>{

    @Type(type="org.hibernate.type.StringClobType")
    @Column(name="defaultValue")
    protected String defaultValue;

    @Override
    public String getDefaultValue() {
        return defaultValue;
    }
}