PseudoClass online = PseudoClass.getPseudoClass("online");

friends.setCellFactory(lv -> {

    ListCell<String> cell = new ListCell<String>() {

        @Override
        protected void updateItem(String friendname, boolean empty) {
            super.updateItem(friendname, empty);
            setText(friendname);
        }

    };

    InvalidationListener listener = obs -> 
        cell.pseudoClassStateChanged(online, 
            cell.getItem() != null
            && usersService.getOnlineUsers().contains(cell.getItem()));
    cell.itemProperty().addListener(listener);
    usersService.getOnlineUsers().addListener(listener);

    return cell ;

});