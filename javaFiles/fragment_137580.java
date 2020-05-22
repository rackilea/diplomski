sommereduction.setCellValueFactory(
        Produit -> {
            SimpleObjectProperty property = new SimpleObjectProperty();
            property.setValue(Produit.getValue().getBondereduction().getSommereduction()));
            return property;
        }
);