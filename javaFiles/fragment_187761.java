class AziendaEditor extends PropertyEditorSupport {
    private AziendaService service;

    public AziendaEditor(AziendaService service) {
        this.service = service;
    }

    @Override
    public void setAsText(String identifier) {
        setValue(service.getAziendaFromId(identifier));
    }
}