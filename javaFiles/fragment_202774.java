// Represents result item
public class ProductBox {
    private final String image;
    private final String title;

    public ProductBox(String image, String title) {
        this.image = image;
        this.title = title;
    }

    public String getImage() { return image; }
    public String getTitle() { return title; }
}


// Method responsible for parsing a page
public void processPage(String url) {
    JBrowserDriver driver = new JBrowserDriver(Settings
            .builder()
            .timezone(Timezone.AMERICA_NEWYORK)
            .userAgent(UserAgent.CHROME)
            .build());

    driver.get(url);
    String pageSource = driver.getPageSource();
    driver.quit();

    Document doc = Jsoup.parse(pageSource);
    Elements prodBoxes = doc.select("ul.prod_list div.prod_box");
    List<ProductBox> products = prodBoxes.stream()
            .map(e -> new ProductBox(e.select("p.img").text(), e.select("p.title").text()))
            .collect(Collectors.toList());

    products.forEach(e -> System.out.printf("%s - %s\n", e.getImage(), e.getTitle()));
}