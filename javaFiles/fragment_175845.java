@Entity
@DiscriminatorValue("manager")
public class Manager extends User { /* stuff */ }

@Entity
@DiscriminatorValue("administrator")
public class Administrator extends User { /* stuff */ }