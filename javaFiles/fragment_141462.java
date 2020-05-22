@GroupSequence({First.class, Second.class})
 public interface Sequence {}

 @Pattern(regexp = "^[ \d]+$", message = "Numeric input required" , groups = { First.class })
 @Pattern(regexp = "^(?:(\d{2})\s?)?(?:(\d{3})\s?)?(\d{7,10})$", message = "Phone no. should be 7-10 in length" , groups = { Second.class })
 private String phoneNumber;