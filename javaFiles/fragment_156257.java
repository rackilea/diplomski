private Button createNumberButton(int value) {
    Button button = new Button(Integer.toString(value));

    button.setOnAction(e -> totalCents.set(totalCents.get() * 10 + value));

    return button ;
}