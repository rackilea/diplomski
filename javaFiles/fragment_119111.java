@Entity
@Table(name = "table_one")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType =    DiscriminatorType.STRING)
public abstract class EntityA {


@Entity
@Table(name = "table_two")
@DiscriminatorValue(value = "B")
public class EntityB extends EntityA {
...
}

@Entity
@Table(name = "table_three")
@DiscriminatorValue(value = "C")
public class EntityC extends EntityA {
...
}