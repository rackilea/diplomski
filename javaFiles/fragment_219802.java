package views;

public class MyHtml extends play.api.templates.Html {
    private String text;

    public MyHtml(String text) {//please take care of HTML injection!!!
        super(scala.collection.mutable.StringBuilder$.MODULE$.newBuilder());
        this.text = text;
    }

    @Override
    public String body() {
        return text;
    }
}