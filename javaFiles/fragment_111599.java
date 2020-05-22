@Override
public void updateItem(LocalDate item, boolean empty) {
    super.updateItem(item, empty);

    boolean disable = rangesToDisable.stream()
            .filter(r->r.initialDate.minusDays(1).isBefore(item))
            .filter(r->r.endDate.plusDays(1).isAfter(item))
            .findAny()
            .isPresent();

    if (item.isBefore(checkInDatePicker.getValue().plusDays(1)) || 
            disable) {
            setDisable(true);
            setStyle("-fx-background-color: #ffc0cb;");
    }
    ...
}