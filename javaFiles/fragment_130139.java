public class Classes {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        List<Class<?>> classes = new ArrayList<>();
        classes.add(Beer.class);
        classes.add(Wine.class);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        for (Class<?> clazz : classes) {
            if (clazz.getSimpleName().equals(input)) {
                Object obj = clazz.newInstance();
            }
        }
    }

    private static class Beer {
        public Beer() {
            System.out.println("A beer has been created.");
        }
    }

    private static class Wine {
        public Wine() {
            System.out.println("A wine has been created.");
        }
    }
}