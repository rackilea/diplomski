class A {

    public void method() {
        // Do something here
        ...
    }
}

class B extends A {

    public void preserveMethodA(){
         super.method();
    }

    @Override
    public void method() {
         // Do something here
         ...
         preserveMethodA()
    }

}

class C extends B {

    @Override
    public void method() {
        if(useB()) {
            // Use B's method
            super.method();
        } else {
            // Use A's method
            super.preserveMethodA()
        } 
    }

}