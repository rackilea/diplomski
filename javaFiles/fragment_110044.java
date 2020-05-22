friends.setCellFactory(lv -> {

    ListCell<String> cell = new ListCell<String>() {

        @Override
        protected void updateItem(String friendname, boolean empty) {
            super.updateItem(friendname, empty);
            if (empty) {
                setText(null);
                setStyle("");
            } else {
                setText(friendname);
            }
        }

    };

    cell.styleProperty().bind(new StringBinding() {
        { bind(cell.itemProperty(), usersService.getOnlineUsers()); }
        @Override
        protected String computeValue() {
            if (cell.getItem() == null) {
                return "" ;
            }
            if (usersService.getOnlineUsers().contains(cell.getItem())) {
                return "/* online style here */";
            }
            return "/* offline style here*/" ;
        }
    });

    return cell ;

});