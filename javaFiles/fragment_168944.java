public String choiceInputDialog( String title, String headerText, String contentText, List choices )
{
    ChoiceDialog<String> choice = new ChoiceDialog( choices.get( 0 ), choices );
    addCheckBox( choice );

    choice.setResultConverter( ( ButtonType type ) ->
    {
        ButtonBar.ButtonData data = type == null ? null : type.getButtonData();
        if ( data == ButtonBar.ButtonData.HELP )
        {
            return "DEBUG@" + choice.getSelectedItem();
        }
        else if ( data == ButtonBar.ButtonData.OK_DONE )
        {
            return "OK@" + choice.getSelectedItem();
        }
        else
        {
            return null;
        }
    } );

    choice.setTitle( title );
    choice.setHeaderText( headerText );
    choice.setContentText( contentText );
    Optional<String> result = choice.showAndWait();
    if ( result.isPresent() )
    {
        System.out.println( "result: " + Arrays.toString( result.get().split( "@" ) ) );
    }
    return null;
}