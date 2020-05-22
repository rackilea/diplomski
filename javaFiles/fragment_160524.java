public class Button {
    private Action<Button> action;

    public Button(Action<Button> action) {
        this.action = action;
    }

    public void Update() {
        // Check if clicked..
        action(this);
    }
}