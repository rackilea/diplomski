// Interface with methods that all these classes have in common 
interface MyClassInterface {
    MyClassInterface copy();
    String getName();
}

@Test
public void testMyClasses() {
    List<String> names = new ArrayList<>();

    // Example list of names
    names.add("adam");
    names.add("ben");
    names.add("carl");

    List<MyClassInterface> objects = new ArrayList<>();


    // Define specialized class with special implementation of getName
    class MyClassWithName implements MyClassInterface {
        private String name;
        public MyClassWithName(String name) {
            this.name = name;
        }

        @Override
        public MyClassInterface copy() {
            return new MyClassWithName(name);
        }

        @Override
        public String getName() {
            return name;
        }

    }

    for (final String name: names) {
        // "register" object
        objects.add(new MyClassWithName(name));
    }

    for (MyClassInterface object: objects) {
        System.out.println("original name " + object.getName());
        // Construct copies as needed
        MyClassInterface object2 = object.copy();
        System.out.println("copy name " + object2.getName());
    }

}