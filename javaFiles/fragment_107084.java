btnDone = new WmvcButton("Done", new WmvcExecutor() {
    public void execute(ActionEvent event) {
        System.out.println("done");
        System.out.println("test 2");
    }
});
btnExit = new WmvcButton("Exit", btnDone.getExecutor());