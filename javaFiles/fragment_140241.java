public class SingleItem {

    @PropertyName("Image")
    private String image;
    @PropertyName("Link")
    private String link;
    @PropertyName("Title")
    private String title;
    @PropertyName("Views")
    private String views;

    public SingleItem() {} //no-argument constructor

    public SingleItem(String image, String link, String title, String views) {
        this.image = image;
        this.link = link;
        this.title = title;
        this.views = views;
    }

    public String getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public String getViews() {
        return views;
    }
}