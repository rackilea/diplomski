public class LboxViewCtrl extends SelectorComposer<Component> {

    @Wire
    private Listbox lbox;
    @Wire
    private Listhead lHead;
    @Wire
    private Panel menu;
    @Wire
    private Listbox box;

    @Listen("onDrop = #lbox > #lHead > listheader")
    public void onDroplHead(DropEvent ev) {
        // get the dragged Listheader and the one it is dropped on.
        Listheader dragged = (Listheader) ev.getDragged();
        Listheader droppedOn = (Listheader) ev.getTarget();
        // then get their indexes.
        int from = lHead.getChildren().indexOf(dragged);
        int to = lHead.getChildren().indexOf(droppedOn);

        // swap the positions
        lHead.insertBefore(dragged, droppedOn);

        // swap related Listcell in all Listitem instances
        for (Listitem item : lbox.getItems()) {
            item.insertBefore(item.getChildren().get(from), item.getChildren().get(to));
        }

    }

}