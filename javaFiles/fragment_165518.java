protected void call()  throws Exception {

  int totalSteps = 100;
  int currentStep = 0;

  // Step one (fast)
  doThis();
  currentStep += 8;
  updateProgress(currentStep, totalSteps);

  // Step two (fast)
  doThisToo();
  currentStep += 8;
  updateProgress(currentStep, totalSteps);

  // Step three (iterates through an ArrayList)
  int nbThings = listOfThings.length;
  double stepPerThing = 75d / (double)nbThings;
  int stepBeforeLoop = currentStep;
  for(int i = 0; i<nbThings; i++) {
    Class clazz = listOfThings[i];
    // Do something with the list
    int step = stepBeforeLoop + (int)((i+1)*stepPerThing);
    updateProgress(step, totalSteps);
  }

  // Step four (fast)
  doThisLast();
  updateProgress(totalSteps, totalSteps);
}