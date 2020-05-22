choice.setResultConverter( ( ButtonType type ) ->
{
    ButtonBar.ButtonData data = type == null ? null : type.getButtonData();
    if ( data == ButtonBar.ButtonData.HELP )
    {
        return "DEBUG";
    }
    else if ( data == ButtonBar.ButtonData.OK_DONE )
    {
        return "OK";
    }
    else
    {
        return null;
    }
} );