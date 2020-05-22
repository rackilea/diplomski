@Override
public void handleEvent(Event event) {
    if (event.widget instanceof Button) {
        String rowId = event.widget.getData("row.id");
        ...
    }
    ...
}