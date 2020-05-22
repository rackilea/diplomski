@Listen("onDrop = #userListbox")
public void onDragDropUserListitem(DropEvent dropEvent){

    userListbox.addEventListener("onDrop", new EventListener<Event>() {

        @Override
        public void onEvent(Event event) throws Exception {