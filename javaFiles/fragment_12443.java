@Entity
public class Cat {
  @Id String name;
  @Embedded
  Fur fur;
}

@Embeddable
public class Fur {
  String color1;
  String color2;
}