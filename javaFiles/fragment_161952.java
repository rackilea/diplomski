class MyButton {

    public MyButton(){};

    public static Button createMyButton(){
        MyButton button = new MyButton();
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                createAlert("I'm button");
            }
        });
        return button;
    }   
}