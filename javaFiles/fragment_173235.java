public void doSomethingCool(Object stuff) {
  if(weWereNotExpectingThis(stuff)) return; //guard clause

  while(somethingHappens()) {
      doSomethingCool();
  }
  return;
}