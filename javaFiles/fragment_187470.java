pane.setOnDragOver(event ->
{
    final Dragboard  dragboard;
    final DataFormat dataFormat;

    dragboard  = event.getDragboard();
    dataFormat = DataFormat.lookupMimeType("application/x-java-serialized-object");

    for (DataFormat df : dragboard.getContentTypes())
    {
        // Do nothing...
    }

    if (dragboard.hasContent(dataFormat))
        event.acceptTransferModes(TransferMode.COPY);

    event.consume();
});