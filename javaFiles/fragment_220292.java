void setEmail(String email) {
  if (!email.contains("@") || !email.contains(".")) {
    throw new IllegalArgumentException("Invalid email: " + email);
  }
  this.emailAddress = email;
}