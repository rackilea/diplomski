lv.setCellFactory(new Callback<ListView<AccountInfo>, ListCell<AccountInfo>>() {
    @Override
    public ListCell<AccountInfo> call(ListView<AccountInfo> param) {
         ListCell<AccountInfo> cell = new ListCell<AccountInfo>() {
             @Override
            protected void updateItem(AccountInfo item, boolean empty) {
                super.updateItem(item, empty);
                if(item != null) {
                    setText(item.getSiteName());
                } else {
                    setText(null);
                }
            }
         };
        return cell;
    }
});