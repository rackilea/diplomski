@Listen("onDrop = #userListbox")
public void onDragDropUserListitem(DropEvent dropEvent){
      Listbox droppedListbox = (Listbox)dropEvent.getTarget());
      Listitem draggedListitem = (Listitem)dropEvent.getDragged();

            if (draggedListitem instanceof Listitem) {

                droppedListbox.insertBefore(draggedListitem, droppedListbox.getNextSibling());

            }else{
                droppedListbox.appendChild(draggedListitem);
            }

}