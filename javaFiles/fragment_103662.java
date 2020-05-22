private static List<? extends A> generateObjects(boolean isItB) {
        if (isItB) {
            return new ArrayList<B>() {
                {
                    add(new B());
                }
            };
        } else {
            return new ArrayList<C>() {
                {
                    add(new C());
                }
            };
        }
    }

    private static void consumeObjects(List<? extends A> consuming) {
        for (A a : consuming) {
            a.doStuff();
        }
    }

    public static void main(String[] args) {
        List<? extends A> generatedBs = generateObjects(false);
        consumeObjects(generatedBs);


    }