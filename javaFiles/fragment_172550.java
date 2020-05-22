public static class Test {

    static class ClassWithUnsafeEqualsMethod {
        @Override
        public boolean equals(Object anObject){
            if (this == anObject) {
                return true;
            }
            //same class?
            if (anObject.getClass() == this.getClass()) {
                Field[] fields = this.getClass().getFields();
                boolean fieldsEqual = true;
                for (Field field : fields) {
                    try {
                        fieldsEqual &=
                                field.get(anObject).equals(field.get(this));
                    } catch (IllegalAccessException e) { }
                }
                //if fields equal, objects are equal.
                return fieldsEqual;
            }
            //not the same class, so the objects aren't equal
            return false;
        }
    }

    static class A extends ClassWithUnsafeEqualsMethod {
        B fieldB;
    }

    static class B extends ClassWithUnsafeEqualsMethod {
        A fieldA;
    }

    public static void main(String... args) {
        A a1 = new A();
        A a2 = new A();
        B b1 = new B();
        B b2 = new B();

        a1.fieldB = b2;
        b2.fieldA = a1;

        a2.fieldB = b1;
        b1.fieldA = a2;

        System.out.println(a1.equals(a2));
    }
}