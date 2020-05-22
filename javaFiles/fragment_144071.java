public class MyView extends ViewPart {
    private Text text1;

    public void createPartControl(Composite parent) {
        text1 = new Text(parent, SWT.None);
        final Text text2 = new Text(parent, SWT.None);

        parent.getDisplay().asyncExec(new Runnable() {
            public void run() {
                text1.setText("Hello");
                text2.setText("World");
            }
        });
    }

    public void setFocus() {
        text1.forceFocus();
    }

    public void someNetworkMessageReceived(MyMessage message) {
        getSite().getShell().getDisplay().asyncExec(new Runnable() {
            public void run() {
                text1.setText(message.toString());
            }
        });
    }
}