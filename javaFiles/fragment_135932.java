package foo.bar.mybasepackage.pages;

public class Index {
    public Object onActivate(EventContext context) {
        if (context.getCount() == 1
                && "robots.txt".equals(context.get(String.class, 0)) {

           return getRobotsTxt();
        }
        if (context.getCount() != 0) {
           return new HttpError(404, "Not found");
        }
        return this;
    }

    private StreamResponse getRobotsTxt() {
        return new TextStreamResponse(...);
    }
}