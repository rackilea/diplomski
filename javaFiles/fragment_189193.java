public class RunIt {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        ToDoList list = new ToDoList("ToDoItems.txt");

        try (PrintWriter fout = new PrintWriter(new File("ToDoItems.txt"))) {
            String inputLine;
            do {
                System.out.println("add to the list? [y/n]");
                inputLine = keyboard.nextLine();

                if ("y".equals(inputLine)) {
                    System.out.println("enter a to-do using the format 'id,description'");
                    StringTokenizer tokenizer = new StringTokenizer(keyboard.nextLine(),
                            ",");
                    String id = tokenizer.nextToken();
                    String description = tokenizer.nextToken();
                    list.addItem(new ToDoItem(id, description));
                } else {
                    System.out.println("Here is the list so far:");
                    System.out.println(list);
                }
            } while ("y".equals(inputLine));
        }
    }
}