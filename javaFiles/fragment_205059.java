final class ToDoTester {
    private final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        final ToDo toDo = new ToDo();
        final ToDoTester toDoTester = new ToDoTester();

        final Scanner reader = toDoTester.getReader();

        while (true) {
            System.out.println("Enter a command (List, New, Change, Delete) or Quit:");

            switch (reader.nextLine()) {
                case "List":
                    toDoTester.display(toDo.list());
                    break;
                case "New":
                    toDo.add(toDoTester.readToDo());
                    break;
                case "Change":
                    final Pair<Integer, String> input = toDoTester.readInputToChange();
                    toDo.update(input.getKey(), input.getValue());
                    break;
                case "Delete":
                    toDo.remove(toDoTester.readIndex());
                    break;
                case "Quit":
                    return;
                default:
                    System.out.println("Incorrect choice, let's try again.");
            }
        }
    }

    public Scanner getReader() {
        return reader;
    }

    public void display(List<String> list) {
        IntStream.range(0, list.size())
                .mapToObj(i -> String.format("[%d] %s", i, list.get(i)))
                .forEach(System.out::println);
    }

    public Pair<Integer, String> readInputToChange() {
        return new Pair<>(readIndex(), readToDo());
    }

    public String readToDo() {
        System.out.println("Enter a to-do:");
        return reader.nextLine();
    }

    public int readIndex() {
        System.out.println("Enter the index of the to-do:");
        return Integer.valueOf(reader.nextLine());
    }

}

final class ToDo {
    private final List<String> list = new ArrayList<>();

    public void add(String toDo) {
        list.add(toDo);
    }

    public void remove(int position) {
        validatePosition(position);
        list.remove(position);
    }

    public void update(int position, String substitute) {
        validatePosition(position);
        list.set(position, substitute);
    }

    private void validatePosition(int position) {
        if (position < 0 || position >= list.size()) {
            // should be thrown an exception
            System.out.println("Incorrect input.");
        }
    }

    public List<String> list() {
        return new ArrayList<>(list);
    }

}