public void doSomethingCool(Object stuff) {
  if(weWereNotExpectingThis(stuff)) return; //guard clause

  while(somethingHappens()) {
    if(somthingHasChanged()) return; //because my team likes early exits, Yay!
    else {
      doSomethingCool();
    }
  }
  return;
}