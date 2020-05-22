class Ex7Inner2 {
    Ex7Inner1 i1 = new Ex7Inner1();  // this is now a field of the Ex7Inner2 class
    public void callBar() {
        i1.bar();                    // this will work
    }
}