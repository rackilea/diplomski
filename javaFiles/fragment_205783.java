Public class someClass {
    private int someVariable;
    private PHSDKListener listener = new PHSDKListener() {
        @Override
        public void onBlablabla(Object something) {
            int localVar1 = someVariable; //this will work
            int localVar2 = someClass.this.someVariable; //this will also work
        }
    };
    public someClass() {
        // constructor
    }
    private void someMehtod() {
        // a standard method that i am used to.
    }
}