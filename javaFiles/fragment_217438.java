//constructor
public YourClass(String ssn) {
  if (!isValidSSN(ssn)) throw new IllegalArgumentException("not a valid SSN: " + ssn);
  this.ssn = ssn;
}

public static boolean isValidSSN(String ssn) {
  //do some validation logic
}