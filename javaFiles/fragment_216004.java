@RequestMapping("/foo/{id}")
public String myActionA(@PathVariable("id") long someId) {
   return myAction(someId, true);
}
@RequestMapping("/debug/foo/{id}")
public String myActionB(@PathVariable("id") long someId) {
   return myAction(someId, false);
}

public String myAction(@PathVariable("id") long someId, boolean doBranch) { ... }