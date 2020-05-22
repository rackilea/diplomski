@Entity
@DiscriminatorValue("BOOLEANVALUE")
public class BooleanValueEvent extends Event {
    ...
}

@Entity
@DiscriminatorValue("EXACTVALUE")
public class ExactValueEvent extends Event {
    ...
}