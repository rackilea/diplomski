String ssn = getSsnFromUser();
while(!YourClass.isValidSSN(ssn)) {
  showErrorMessage("Not a valid ssn: " + ssn);
  ssn = getSsnFromUser();
}
//at this point, the SSN is valid:
YourClass yc = new YourClass(ssn);