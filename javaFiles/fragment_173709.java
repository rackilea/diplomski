@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
@Polymorphism(type = PolymorphismType.IMPLICIT)
@MappedSuperClass
public abstract class Element{
  ...
}


@Entity
@DiscriminatorValue("tv")
public class TVElement extends Element{
  ...
}


@Entity
@DiscriminatorValue("episode")
public class TVEpisode extends TVElement{
  ...
}