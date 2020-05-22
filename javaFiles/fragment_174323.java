public class Print {
    public static void main(final String[] args) {
        List<Dog> list = new ArrayList<Dog>();
        Dog e = new Dog("Tommy");
        list.add(e);
        list.add(new Dog("tiger"));
        System.out.println(list);
        for(Dog d:list) {
            System.out.println(d);
            // prints [Tommy, tiger]
        }
    }

    private static class Dog {
        private final String name;
        public Dog(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}