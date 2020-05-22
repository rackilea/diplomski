@MappedSuperclass
public abstract class A {
    @Id
    @GeneratedValue
    long id;
}

@MappedSuperclass
public abstract class E {
    @GeneratedValue
    long id;
}

@Embeddable
public class B extends E {

}

@Entity
public class C extends A {
    B b;
}