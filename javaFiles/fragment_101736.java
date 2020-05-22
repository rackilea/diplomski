Path filePath = Paths.get("QuestionSheet.txt");
List<String> lines = Files.readAllLines(filePath); // using nio for simplicity here

buttonNext.setOnAction(new EventHandler<ActionEvent>(){

    // iterator for stepwise iterating through the list
    private final Iterator<String> iterator = lines.iterator();

    @Override
    public void handle(ActionEvent event){
        if (iterator.hasNext()) {
            String[] lineOfCsv = iterator.next().split(",");
            questionLabel.setText(lineOfCsv[0]);
            aRadio.setText(lineOfCsv[1]);
            bRadio.setText(lineOfCsv[2]);
            cRadio.setText(lineOfCsv[3]);
            dRadio.setText(lineOfCsv[4]);
            buttonNext.setDisable(!iterator.hasNext());
        }

    }
});