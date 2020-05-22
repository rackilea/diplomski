class MyClickHandler implements ClickHandler {
    int i;

    MyClickHandler(int i) {
        this.i = i;
    }

    @Override
    public void onClick(MyClickEvent event) {  // MyClickEvent!
        // do something
    }
}