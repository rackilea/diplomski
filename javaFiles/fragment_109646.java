@Entity
@Table(name="THE_TABLE")
@Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(name="purpose", discriminatorType=STRING)
@DiscriminatorValue("PRICING")
public class Pricing{ ... }