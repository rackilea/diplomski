public void start(Stage PrimaryStage) {
    File file1, file2;
    ...
    input2.setOnAction(
    new EventHandler<ActionEvent>() {
        public void handle(final ActionEvent e) {
        file1 = inputFile.showOpenDialog(PrimaryStage);
        Label label2 = new Label(file1.getPath());
        pane.add(label2, 1, 1);                         
        }           
    });
    output1.setOnAction(
    new EventHandler<ActionEvent>() {
        public void handle(final ActionEvent e) {
        file2 = outputFile.showDialog(PrimaryStage);
        System.out.print(file2.getPath());
        Label label3 = new Label(file2.getPath());
        pane.add(label3, 1, 2);                         
        }           
    });
    ...
    execute.setOnAction(
        new EventHandler<ActionEvent>() {
            public void handle(final ActionEvent e) {
                if (file1 != null) {
                    XSSFWorkbook wb = new XSSFWorkbook(file1);
                }
                if (file2 != null) {
                    XSSFWorkbook wb2 = new XSSFWorkbook(file2);
                }
                ...
            }           
    });