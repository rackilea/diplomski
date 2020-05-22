@Inject
private Block formFieldsBlock;

@OnEvent(component = "injector")
Block loadExtraFormFields() {
    return this.formFieldsBlock;
}