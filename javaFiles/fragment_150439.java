final DateField datePublishDateFrom = new DateField("publishDateFromInput", new Model<Date>(Const.DATE)) {

        @Override
    protected DateTextField newDateTextField(String id, PropertyModel dateFieldModel) {
                 DateTextField dateInput =  DateTextField.forDatePattern(id, dateFieldModel, "yyyy-MM-dd");
                dateInput.add(createAjax());
            return dateInput;
        }
    };  



private AjaxFormComponentUpdatingBehavior createAjax() {
    return new AjaxFormComponentUpdatingBehavior("onchange") {
        @Override
        protected void onUpdate(AjaxRequestTarget target) {
            setResponsePage(BasePage.class);
        }
    };
}