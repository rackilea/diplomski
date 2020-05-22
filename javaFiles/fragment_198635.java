public class SingleRun {}

@ValidationOne(groups={SingleRun.class, javax.validation.groups.Default.class})
@ValidationTwo
@Entity
public class MyClass{...}