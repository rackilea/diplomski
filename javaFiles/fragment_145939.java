public void setFirstName(String firstName) {
  if (firstName != null && firstName.isEmpty())
    this.firstName = null;
  else
    this.firstName = firstName;
}