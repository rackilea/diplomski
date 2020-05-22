public static void main(String[] args) throws IOException {
    Document doc = Jsoup.connect(URL).userAgent("Chrome").timeout(5000).get();

    Elements titles = doc.select("myCssQuery");
    Elements prices = doc.select("myCssQuery");
    Elements locations = doc.select("myCssQuery");
    Elements dates = doc.select("myCssQuery");

    List<Item> items = new ArrayList<>();
    Item item;
    for(int i = 0; i < titles.size()-1; i++) {
        item = new Item(titles.get(i).text(), Integer.parseInt(prices.get(i).text().replaceAll("\\D+","")), locations.get(i).text(), dates.get(i).text());    
        items.add(item);
    }

    Collections.sort(items, new Comparator<Item>() {
        @Override
        public int compare(Item item1, Item item2) {
            return item1.compareTo(item2);
        }
    });

}

public static class Item implements Comparable {
    private String title;
    private int price;
    private String location;
    private String date;

       public Item(String title, int price, String location, String date) {
        this.title = title;
        this.price = price;
        this.location = location;
        this.date = date;
       }

    @Override
    public int compareTo(Object o) {
        Item item = (Item) o;
        if (this.price == item.price) {
            return 0;
        } else if (this.price > item.price) {
            return 1;
        } else {
            return -1;
        }
    }
}