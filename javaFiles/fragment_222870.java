class InterfacesExample {
    public static void main(String[] args) {
        @SuppressWarnings("unchecked") // Arrays#asList
        List<Class<? extends Printer>> classes = Arrays.asList(
            FruitPrinter.class,
            TreePrinter.class
        );

        for(Class<? extends Printer> cls : classes) {
            try {
                Constructor<? extends Printer> ctor = cls.getDeclaredConstructor();
                Printer p = ctor.newInstance();
                p.print();
            } catch(Exception e) {
                System.err.println(e);
            }
        }
    }
}

interface Printer {
    void print();
}

class FruitPrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Apple, Banana, Plum, Pear");
    }
}

class TreePrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Oak, Maple, Elm, Willow");
    }
}