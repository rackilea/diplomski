public class HandlingInputExample {
    private ClickListener inputHandler; //injected by setter/constructor
    private String myText = "hello ";
    private int myInt = 2;

    private void init() {
        Button button = new Button();
        button.setData(this);
        button.addClickListener(new SetCaptionClickListener(new Context(this)));
    }
}

public class SetCaptionClickListener implements ClickListener {
    private Label label; //injected by setter/constructor
    private Context context;

    public SetCaptionClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void buttonClick(ClickEvent event) {
        label.setCaption(context.getCaption());
    }
}

public class Context {
    HandlingInputExample handlingInputExample;

    public Context(handlingInputExample handlingInputExample) {
        this.handlingInputExample = handlingInputExample;
    }

    public String getCaption() {
        return handlingInputExample.getMyText() + handlingInputExample.getMyInt();
    }
}