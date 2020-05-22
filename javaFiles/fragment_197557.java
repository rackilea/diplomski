public class MySubscriber implements Subscriber<MyNews> {

    // ...

    public Class<MyNews> getSupportedNewsType() {
        return MyNews.class;
    }
}