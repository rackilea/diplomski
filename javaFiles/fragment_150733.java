MyClass myVar; // myVar is not instanciated
try {
    myVar.myFct(); // NPE is thrown here !
} catch (NullPointerException npe) {
    // do nothing : **can be dangerous, don't do this ! **
    // basic code here should be at least: npe.printStacktrace();
}