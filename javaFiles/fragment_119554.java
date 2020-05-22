implFileBtn.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter("myfile.txt", true)))) {
            out.println(text1.getText());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
});