public class ScopeClass(){ //this is the start of the class level scope
    private String classString = "this can been seen anywhere in the class";
    public void scopeMethod(){ //this starts the method level scope
        private String methodString = "this is only visible in the method";
        { //start of internal scope block
            private String internalString = "only visible in this scope block";
        } 
    }
}