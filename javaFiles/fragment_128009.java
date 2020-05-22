package foo.bar.framework;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract public class AbstractEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = false)
    @Version
    protected Long consistencyVersion;

    ...
}