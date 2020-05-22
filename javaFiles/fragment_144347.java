protected void updateItem(PowerPlantPM pp, boolean empty) {
        super.updateItem(pp, empty);
        if (!empty && pp != null) {
            if (!pp.isSaved()) {
                 getStyleClass().add("unsaved");
            } else {
                 getStyleClass().remove("unsaved");
            }
            .....
        }
 }