public void actionPerformed(final ActionEvent actionEvent) {
    final String name = ((JComponent) actionEvent.getSource()).getName();
    switch (name) {
        case "label1":
            handleLabel1();
            break;
        case "label2":
            handleLabel2();
            break;
        case "label3":
            handleLabel3();
            break;
        default:
            break;
    }
}