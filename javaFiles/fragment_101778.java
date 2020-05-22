@Override
public void onFailure(Throwable caught)
{
    if(caught instanceof DatabaseException)
        Window.alert(caught.getLocalizedMessage());
}