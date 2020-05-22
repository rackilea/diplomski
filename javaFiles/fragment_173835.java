//Get the content
datePicker.onShown(e -> {
        DatePickerContent content = (DatePickerContent)((DatePickerSkin)datePicker.getSkin()).getPopupContent();
        content.lookupAll(".day-cell").forEach(cell -> { 
            cell.getStyleClass().add("selected");
        });
}