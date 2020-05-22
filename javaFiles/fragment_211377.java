@Wire
    private Window menu;
    @Wire
    private Listbox box;

    private Listhead lHead;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        // get the Listboxhead in which we like to change the the col order
        lHead = (Listhead) menu.getParent().query("#lbox > #lHead");
        // set the model for Listbox box in the pop up
        box.setModel(new ListModelList<>(lHead.getChildren()));
    }

    @Listen("onDrop = listitem")
    public void onDropInMenu(DropEvent ev) {
        // get the draged and dropped again
        Listitem dragged = (Listitem) ev.getDragged();
        Listitem droppedOn = (Listitem) ev.getTarget();

        // then get their indexes.
        int from = box.getItems().indexOf(dragged);
        int to = box.getItems().indexOf(droppedOn);

        // swap the positions
        lHead.insertBefore(lHead.getChildren().get(from), lHead.getChildren().get(to));

        // swap related Listcell in all Listitem instances
        for (Listitem item : lHead.getListbox().getItems()) {
            item.insertBefore(item.getChildren().get(from), item.getChildren().get(to));
        }

        // swap the items in pop up Lisbox as well
        box.insertBefore(dragged, droppedOn);
    }