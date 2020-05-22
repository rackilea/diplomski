private ReadOnlyObjectWrapper<SelectionMode> selectionMode
    = new ReadOnlyObjectWrapper<>(this, "selectionMode");

public final ReadOnlyObjectProperty<SelectionMode> selectionModeProperty() {
    return selectionMode.getReadOnlyProperty();
}

private final SelectionMode getSelectionMode() {
    return selectionMode.get();
}