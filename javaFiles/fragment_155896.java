private String[] questions;
private Label label;
private button btnYes;
private button btnNo;
private int index = 0;

btnYes.setOnAction(event -> label.setText(questions[index++]));
btnNo.setOnAction(event -> label.setText(questions[index++]));