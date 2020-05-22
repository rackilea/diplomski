public class MyButton extends Button {
    public MyButton(MyHandler handler) {
        super();
        setOnAction(handler);
    }
}