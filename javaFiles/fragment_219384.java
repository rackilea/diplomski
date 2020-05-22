@Entity
@Table(name="ecc.\"RATE\"")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISCRIMINATOR", discriminatorType= DiscriminatorType.STRING)
@org.hibernate.annotations.ForceDiscriminator
public abstract class Rate extends GenericBusinessObject {
    ...
}