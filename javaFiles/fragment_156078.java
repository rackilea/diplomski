public class SuperWindow {
    protected void updateLabel(JLabel label) {
       label.setText("foo");
    }
}

public class WindowA extends SuperWindow {
    private JLabel labelA;
    //...

    private void somethingHappened() {
      updateLabel(labelA);
    }
}