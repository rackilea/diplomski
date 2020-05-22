This exception may occur if matchers are combined with raw values:
     //incorrect:
     someMethod(anyObject(), "raw String");
 When using matchers, all arguments have to be provided by matchers.
 For example:
     //correct:
     someMethod(anyObject(), eq("String by matcher"));