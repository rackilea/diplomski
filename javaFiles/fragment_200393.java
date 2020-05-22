public class SO_Nested {

    public static class A {
        public List<B> classesOfB = new ArrayList<>();

        public void addTree(List<Object> objects) {

            for (int i = 0; i < objects.size(); i++) {

                List<Object> addUnder = new ArrayList<>();

                B currentB = (B)objects.get(i);

                classesOfB.add(currentB);

                while(i < objects.size() - 1 && C.class.isInstance(objects.get(i + 1))) {
                    addUnder.add(objects.get(i + 1));
                    i++;
                }

                currentB.addTree(addUnder);
            }
        }
    }

    public static class B {
        public List<C> classesOfC = new ArrayList<>();

        public void addTree(List<Object> objects) {
            classesOfC.addAll(objects.stream().map(C.class::cast).collect(Collectors.toList()));
        }
    }

    public static class C {

    }

    public static void main(String[] args) {
        List<Object> allClasses = generateClassesOfA();
        allClasses.addAll(generateClassesOfB());
        allClasses.addAll(generateClassesOfC());
        allClasses.addAll(generateClassesOfB());
        allClasses.addAll(generateClassesOfC());
        allClasses.addAll(generateClassesOfA());
        allClasses.addAll(generateClassesOfB());
        allClasses.addAll(generateClassesOfB());
        allClasses.addAll(generateClassesOfC());

        List<A> sturcture = new ArrayList<>();

        for (int i = 0; i < allClasses.size(); i++) {

            List<Object> addUnder = new ArrayList<>();

            A currentA = (A)allClasses.get(i);
            sturcture.add(currentA);

            while(i < allClasses.size() - 1 && !A.class.isInstance(allClasses.get(i + 1))) {
                addUnder.add(allClasses.get(i + 1));
                i++;
            }

            currentA.addTree(addUnder);
        }

        System.out.println("");
    }




    private static List<Object> generateClassesOfA() {
        return IntStream.range(0, 1).mapToObj((unused) -> new A()).collect(Collectors.toList());
    }

    private static List<Object> generateClassesOfB() {
        return IntStream.range(0, 2).mapToObj((unused) -> new B()).collect(Collectors.toList());
    }

    private static List<Object> generateClassesOfC() {
        return IntStream.range(0, 2).mapToObj((unused) -> new C()).collect(Collectors.toList());
    }
}