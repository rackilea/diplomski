Greetings getGreetings() {
  if (aCondition) {
     return new Greetings("Hello");
  }
  return null; // caller will have to test a null condition to know it the operation was ok
}