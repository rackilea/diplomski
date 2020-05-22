void WorriedFunction(...)  
 {    assert(argument1 != null); // fail/abort if false [I think your example had the test backwards]
      assert(argument2 + argument3 >= 0);
      assert(!stateManager.currentlyDrawing());
      /* body of function goes here */ 
 }