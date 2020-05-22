final Widget widget = horizontalPanel.getWidget(0);
if (widget instanceof Button) {
    System.out.println("It's a button!");
} else if (widget instanceof TextBox) {
    System.out.println("It's a textbox!");
}