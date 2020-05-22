@Listen("onDrop = #userListbox")
public void onDragDropUserListbox(DropEvent dropEvent) {
    userListbox.appendChild(dropEvent.getTarget());
}

@Listen("onDrop = listitem")
public void onDragDropUserListitem(DropEvent dropEvent) {
    Listitem droppedListitem = (Listitem) dropEvent.getTarget();
    Listitem draggedListitem = (Listitem) dropEvent.getDragged();

    userListbox.insertBefore(draggedListitem, droppedListitem);
}