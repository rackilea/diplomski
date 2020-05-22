public final class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
    // Double
    PropertyEditor doubleEditor = getLocaleBasedNumberEditor(Double.class, true);
    registry.registerCustomEditor(double.class, doubleEditor);
    registry.registerCustomEditor(Double.class, doubleEditor);
}