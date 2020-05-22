public class MySubscriber {
    // ...

    @Subscribe
    public void handleNews(MyNews news) {
        // Handle news
    }

    @Subscribe
    public void handleNews(YourNews news) {
        // Handle news
    }
}