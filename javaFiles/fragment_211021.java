@Override
    public void start(Stage primaryStage) throws Exception {
        Parameters parameters = getParameters();

        List<String> unnamed = parameters.getUnnamed();
        for (String s : unnamed) {
            System.out.println(s + " (unnamed)");
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setContentText(s + " (unnamed)");
            al.show();
        }

        List<String> raw = parameters.getRaw();
        for (String s : raw) {
            System.out.println(s + " (raw)");
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setContentText(s + " (raw)");
            al.show();
        }
}