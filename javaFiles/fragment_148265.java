class A {

    public String getMyClassname() {
        return this.getClass().getSimpleName();
    }
}


class B extends A {}