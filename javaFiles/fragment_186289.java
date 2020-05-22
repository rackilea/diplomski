private void createBindings(Service oldService) {
    // Unbind if there is an older service
    if (oldService != null) {
        servicePriceField.textProperty().unbindBidirectional(oldService.sellingPriceProperty());
        serviceDescriptionField.textProperty().unbindBidirectional(oldService.descriptionProperty());
    }

    servicePriceField.textProperty().bindBidirectional(service.get().sellingPriceProperty(), new BigDecimalStringConverter());
    serviceDescriptionField.textProperty().bindBidirectional(service.descriptionProperty());
}