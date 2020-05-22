public static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

public static void main(String[] args) throws IOException {
    List<String> toDoList = new ArrayList<String>();
    System.out.println("Please type the item to add to the To-Do List");
    while (true) {
        String newItem = buf.readLine();
        if (newItem == null || newItem.isEmpty()) {
            break;
        }
        toDoList.add(newItem);

    }
    System.out.println("Your item has been added! Type any key and press Enter to continue");

    for (String s : toDoList) {
        System.out.println(s);
    }
}