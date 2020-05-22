private static void customSortCsv() throws IOException {
    ArrayList<Key> list = new ArrayList<>();
    BufferedReader br = new BufferedReader(new FileReader("data.csv"));
    String line;
    int idx = 0;

    while ((line = br.readLine()) != null) {
        if (idx == 0) {
            idx++;
            continue;
        }
        String[] arr = line.split(";");
        list.add(new Key(arr[0], arr[1], arr[2], arr[3]));
    }

    Collections.sort(list, (o1, o2) -> {
        int c = o2.url.compareTo(o1.url);
        if (c != 0) {
            return c;
        }

        c = o2.priority.compareTo(o1.priority);
        if (c != 0) {
            return c;
        }

        return o2.length.compareTo(o1.length);
    });

    list.forEach(System.out::println);
}

static class Key {
    String url;
    String review;
    Integer priority;
    Integer length;

    public Key(String url, String review, String priority, String length) {
        this.url = url;
        this.review = review;
        this.priority = Integer.parseInt(priority);
        this.length = Integer.parseInt(length);
    }

    @Override
    public String toString() {
        return url + ";" + review + ";" + priority + ";" + length;
    }
}