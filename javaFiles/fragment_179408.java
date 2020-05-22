@MappedSuperclass
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISCRIM", discriminatorType=INTEGER)
public abstract class A {
   // properties here
}