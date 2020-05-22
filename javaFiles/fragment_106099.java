@Override
protected void onSaveInstanceState(Bundle persistantState)
{
    if (this.connectionPasswordDialogue != null)
    {
        this.connectionPasswordDialogue.dismiss();
    }
}