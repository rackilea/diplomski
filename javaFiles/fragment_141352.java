@Override
public void undoableEditHappened(UndoableEditEvent e)
{
    //  Check for an attribute change

    AbstractDocument.DefaultDocumentEvent event =
        (AbstractDocument.DefaultDocumentEvent)e.getEdit();

    if  (event.getType().equals(DocumentEvent.EventType.CHANGE))
        return
    else
        super.undoableEditHappened(e);
}