@Entity
public class FooSequence {
    @Id
    @GeneratedValue(...)
    private Long value;
}

@Entity 
public class Whatever {
    @OneToOne(...)
    private FooSequnce newColumn;
}