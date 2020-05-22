public class ToDoList {

    private ArrayList<ToDoItem> items = new ArrayList<ToDoItem>();

    public ToDoList(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        try {
            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(nextLine, ",");
                String id = tokenizer.nextToken();
                String description = tokenizer.nextToken();
                items.add(new ToDoItem(id, description));
            }
        } finally {
            scanner.close();
        }
    }

    public void setItems(ArrayList<ToDoItem> newItems) {
        this.items.addAll(newItems);
    }

    public List<ToDoItem> getItems() {
        return items;
    }

    public void addItem(ToDoItem item) {
        items.add(item);

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ToDoList{");
        for (ToDoItem item : items) {
            builder.append(item.getId() + "," + item.getDescription() + "\n");
        }
        builder.append("}");

        return builder.toString();
    }
}