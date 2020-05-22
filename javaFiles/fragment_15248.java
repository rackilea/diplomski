@Entity
@DiscriminatorValue("c")
public class C extends X {
    List<D> listOfD;
    // ...
}

@Entity
@DiscriminatorValue("d")
public class D extends X {
    String value;     
    // ...
}