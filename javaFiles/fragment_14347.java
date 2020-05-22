@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
@Table(name = "figures")
public class Figure{

}

@Entity
@DiscriminatorValue("S")
public class Square extends Figure{

}

@Entity
@DiscriminatorValue("C")
public class Circle extends Figure{

}