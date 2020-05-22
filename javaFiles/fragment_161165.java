@MappedSuperClass
 public class Base{
    @Size(min=4, groups = BaseGroup.class)
    String name;
}

public class Child extends Base{
    @NotBlank(groups = ChildChecks.class)
    String surname;
} 

Base base = new Base();
Set<ConstraintViolation<Base>> baseViolations = validator.validate( base , ChildChecks.class);
// I suppose that this list will always be empty, because no constraints are defined for ChildChecks group in Base class

Child child = new Child();
Set<ConstraintViolation<Child>> childViolations = validator.validate( child,  BaseGroup.class, ChildChecks.class );
// All checks wil be verified here, because we use two groups