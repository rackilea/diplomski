public static void main(String[] args){
    File file = new File("ToDoItems.txt");
    ToDoItem td = new ToDoItem();
    ToDoList tl = new ToDoList();

    Scanner keyboard = new Scanner(System.in);

    ArrayList<String> list = new ArrayList<>();
    String inputline;

    System.out.println("Welcome to the list maker!" + "\n" + "Please start typing.");
    try (PrintWriter fout = new PrintWriter(file)) {
    //                                       ^^ here
        do {
            System.out.println("add to the list? [y/n]");
            inputline = keyboard.nextLine();

            if ("y".equals(inputline)) {
                fout.print(td.getDescription() + System.lineSeparator());
            } else {
                // Important line is here!
                fout.close(); // <--- Close printwriter before read file

                System.out.println("Here is the list so far:");
                Scanner ReadFile = new Scanner(file);

                while (ReadFile.hasNext()) {
                    String listString = ReadFile.nextLine();
                    list.add(listString);
                }
            }
        } while ("y".equals(inputline));
    } catch (FileNotFoundException e) {
        System.err.println(e.getMessage());
    }
    System.out.println(list);
}