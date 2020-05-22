@MappedSuperclass
@Access(value=AccessType.FIELD)
public class Parent { 
}

@Entity
public class Child extends Parent {
    ...
}