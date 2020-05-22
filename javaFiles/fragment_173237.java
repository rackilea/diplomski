public void doSomethingCool(Object stuff) {
  if(weWereNotExpectingThis(stuff)) return; //guard clause

  while(somethingHappens()) {
    if(somthingHasChanged()) return;
    else if(weDetectNewInput()) {
      doSomethingCool();
    } else {
      doSomethingBoring();
      if(weDetectCoolInput()) {
        doSomethingCool();
        continue;
      }
      return;
    }
  }
  return;
}