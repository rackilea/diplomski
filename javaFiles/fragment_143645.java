@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS ) 
@DiscriminatorColumn(name="DISC", discriminatorType=STRING, length=20)
class abstract Something {

    @Id 
    @Column 
    Long id;

    @Column 
    String name;

    @Column 
    String description;

    //getters, setters, constructors 
}

@Entity
@Table("FOO_SOMETHING")
@Immutable
@DiscriminatorValue("FooSomething")
class FooSomething extends Something {

}

@Entity
@Table("BAR_SOMETHING")
@Immutable
@DiscriminatorValue("BarSomething")
class BarSomething extends Something {

}