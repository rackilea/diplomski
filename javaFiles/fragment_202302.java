@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorForumula("CATEGORY || '_' || TYPE")
public abstract class A 

@Entity
@DiscriminatorValue(value = "B_X")
public class X extends A {}

@Entity
@DiscriminatorValue(value = "B_Y")
public class Y extends A {}

@Entity
@DiscriminatorValue(value = "B_Z")
public class Z extends A {}