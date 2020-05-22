@UrlBinding("/sharedContent")
public class SharedContentBean implements ActionBean {

    String contentParam;

    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution("/sharedContent.jsp");
    }
}