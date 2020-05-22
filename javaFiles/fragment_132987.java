//remove static here
private class InnerClass { 
    public void someMethod() {
        OtherClass.otherMethod(OuterClass.this);
    }
}