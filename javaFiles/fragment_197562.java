public class MySubscriber {
    // ...

    @Subscribe
    public void anyMethodNameYouWant(MyNews news) {
        // Handle news
    }

    @Subscribe
    public void anEntirelyDifferentMethod(MyNews news) {
        // Handle news
    }
}