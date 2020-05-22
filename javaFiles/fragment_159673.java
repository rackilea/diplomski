public ListCell<String> call(ListView<String> param) {
    ListCell<String> cell = new ListCell<String>() {
        @Override
        protected void updateItem(String t, boolean bln) {
            super.updateItem(t, bln);
            if (t == null) {
                setText(null);
                getStyleClass().remove("mystyleclass");
            } else {
                setText(t);

                if (!controller.checkGerecht(t)) {

                    if (!getStyleClass().contains("mystyleclass")) {
                        getStyleClass().add("mystyleclass");
                        foutieveInput.add(t);
                    } 
                } else {
                    getStyleClass().remove("mystyleclass");
                }
            }

        }
    };
    return cell ;
}