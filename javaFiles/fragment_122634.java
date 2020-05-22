public class PageIndex extends FlowPanel {
    protected final PageContent content;
    ...

    public PageIndex() {
        content = new PageContent(this);
        this.add(content);
        ...
    }

    public PageContent getContent() {
        return this.content;
    }
}

public class PageContent extends FlowPanel {
    protected final PageIndex index;

    public PageContent(PageIndex index) {
        this.index = index;
    }

    public PageIndex getIndex() {
        return this.index;
    }

    public void exampleFunction() {
        createLabel().setLabel("HOLAAA").setStyle("content_title");
    }
}

public class PageMenuLogin extends FlowPanel {
    protected final PageIndex index;

    public PageContent(PageIndex index) {
        this.index = index;
        index.getContent().exampleFunction();
    }

    public PageIndex getIndex() {
        return this.index;
    }
}