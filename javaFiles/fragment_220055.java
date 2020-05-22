/**
 * Property editor to map Documents from documents IDs.
 */
 class DocumentPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Long id = Long.parseLong(text);
        Document value = id == 0 ? null : documentService.get(id);
        setValue(value);
    }

    @Override
    public String getAsText() {
        Document d = (Document) getValue();
        return d != null ? String.valueOf(d.getId()) : "";
    }
}