for(i=0;i<b.getRow();i++)
{   
    buttons[i]=new Button("Row"+(i+1));
    buttonsPane.addColumn(i+1, buttons[i]);
    final index = i;
    buttons[i].setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) 
        {
            circles[0][index].text.setText("Clicked.");
        }
    });
}