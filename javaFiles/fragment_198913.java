JButton pieceToMoveButton = null;   //variable that persists between actionPerformed calls

public void actionPerformed(ActionEvent actionEvent)
{
    JButton button = (JButton)actionEvent.getSource();

    if (pieceToMoveButton == null)    //if this button press is selecting the piece to move
    {
        //save the button used in piece selection for later use
        pieceToMoveButton = button;
    }
    else        //if this button press is selecting where to move
    {
        //move the image to the new button (the one just pressed)
        button.imageIcon = pieceToMoveButton.imageIcon
        pieceToMoveButton = null;    //makes the next button press a piece selection
    }
}