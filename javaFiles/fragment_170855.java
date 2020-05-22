public class HandlingInputExample {
    private ClickListener inputHandler; //injected by setter/constructor
    private String myText = "hello ";
    private int myInt = 2;

    private void init() {
        Button button = new Button();
        button.setData(this);
        button.addClickListener(new SetCaptionClickListener(example.getMyText() + example.getMyInt()));
    }
}

public class SetCaptionClickListener implements ClickListener {
    private Label label; //injected by setter/constructor
    private String caption;

    public SetCaptionClickListener(String caption) {
        this.caption = caption;
    }

    @Override
    public void buttonClick(ClickEvent event) {
            label.setCaption(caption);
    }
}