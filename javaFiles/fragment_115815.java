/**
 * All implementations should check proper condition
 */
interface Condition { 

  /**
   * Check if condition is satisfied
   *
   * @param pathToFile path to target file
   * @return 'true' if condition is satisfied, otherwise 'false'
   */
  boolean isSatisfied(String pathToFile); //i've made an assumption that you'll manipulate file path for checking file
}
...
/**
 * Childs will wrap some portion of code (if you'll use language, that supports lambdas/functors, this interface/implementation can be replaced with lambda/functor)
 */
interface Action {

  /**
   * Execute some portion of code
   *
   * @param pathToFile path to target file
   */ 
  void execute(String pathToFile);
}
...
class ZipFileExistsCondition implements Condition {

  @Override
  public boolean isSatisfied(String pathToFile) {
   ... //check if zip file exists
  }
}
...
class ZipFileDoesNotExists implements Condition {
  @Override
  public boolean isSatisfied(String pathToFile) {
   ... //download zip file and move it to some temp directory
   //if file downloaded ok, than return 'true' otherwise 'false'
  }
}
...
class AlwaysSatisfiedCondition implements Condition {
  @Override
  public boolean isSatisfied(String pathToFile) {
   ... //always returns 'true', to run action assigned with this condition
  }
}
...
Collection<Map.Entry<Condition, Action>> steps = Arrays.asList(
 new AbstractMap.ImmutableEntry<Condition, Action>(new ZipFileExistsCondition(), 
 new Action() { /*move zip file to zip file directory and read in file*/ }),
 new ZipFileDoesNotExists(), new Action() { /*download it from specified URL and then unzip it and read in file and move zip file to specified directory*/ },
 new AlwaysSatisfiedCondition(), new Action() { /*create blank file and write it out to disk*/  }
);
...
String pathToFile = ...
...
for(Map.Entry<Condition, Action> step: steps) {
 if(!step.getKey().isSatisfied(pathToFile))
   continue;

 step.getValue().execute(pathToFile); 
}