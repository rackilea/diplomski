class Book {
    private int id;
    private String title;

    public Book() {
    }

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

        @Override
    public String toString() {
        return "Book[Title:" + this.getTitle() + ", Id:" + this.getId() + "]";
    }

    // Getters and Setters
}

public class Demo {
    public static void main(String[] args) {

        final Map<String, Book> map = new HashMap<String, Book>() {
            {
                put("b1", new Book(3, "abc"));
                put("b2", new Book(2, "c"));
            }
        };
        List<Map.Entry<String, Book>> keyList = new LinkedList<Map.Entry<String, Book>>(map.entrySet());

        Collections.sort(keyList, new Comparator<Map.Entry<String, Book>>() {
            @Override
            public int compare(Map.Entry<String, Book> o1, Map.Entry<String, Book> o2) {
                return o1.getValue().getId() - o2.getValue().getId();
            }
        });


        Map<String, Book> result = new LinkedHashMap<String, Book>();
        for (Iterator<Map.Entry<String, Book>> it = keyList.iterator(); it.hasNext();) {
            Map.Entry<String, Book> entry = it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        System.out.println(result);
    }
}