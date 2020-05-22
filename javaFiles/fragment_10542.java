public interface Style {

    public void display();
}

public abstract class ActionFrame {
    private Style mStyle;
    public void addStyle(Style style) {
        mStyle = style;
    }
    public Style getStyle(){
        return mStyle;
    }
}

public class Test {
    public static void main(String[] args) {
        CActionFrame cActionFrame = new CActionFrame();
        cActionFrame.addStyle(new Style() {

            @Override
            public void display() {
                System.out.println("aaaaaaaaaaaaaaa");
            }
        });


        cActionFrame.getStyle().display();
    }
}