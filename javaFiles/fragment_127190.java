@GroupSequence({First.class, Second.class})
public interface Sequence {}

@Size(min = 2, max = 10, message = "Name length improper", groups = { First.class })
@Pattern(regexp = "T.*", message = "Name doesn't start with T" , groups = { Second.class })
private String name;