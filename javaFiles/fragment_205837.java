// Syntax to get a new empty structure array (4 cells) to pass to a function
// which will populate it
MyStructureClass[] incomingStructArray = new MyStructureClass().toArray(4);

// Syntax to transform a standard java array to an array suitable 
// to be passed to a C function
MyStructureClass[] standardJavaStructArray = ....
MyStructureClass[] outgoingStructArray = new MyStructureClass().toArray(standardJavaStructArray);