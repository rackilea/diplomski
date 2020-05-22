public class TestingPanel extends Panel {
    public TestingPanel(String id) {
    super(id);

    final CompoundModel compoundModel = new CompoundModel();

    final Form<CompoundModel> form = new Form<CompoundModel>("form",
            new CompoundPropertyModel<CompoundModel>(compoundModel)) {
        @Override
        protected void onValidate() {
            System.out.println("validate: "
                    + compoundModel.getChangeableTxt());
            System.out.println("validate: "
                    + getModel().getObject().getChangeableTxt());

            super.onValidate();
        }
    };
    form.setOutputMarkupId(true);
    add(form);

    TextField someText = new TextField("someText");
    someText.setRequired(true); // added validation on requireness
    final CheckBox checkBx = new CheckBox("checkBx");
    final TextField changeableTxt = new TextField("changeableTxt");
    changeableTxt.setOutputMarkupId(true);
    changeableTxt.setEnabled(false);

    Form checkBoxForm = new Form("checkBoxForm");
    form.add(checkBoxForm);

    AjaxFormSubmitBehavior submitBehavior = new AjaxFormSubmitBehavior(
            checkBoxForm, "onclick") {

        @Override
        protected void onSubmit(AjaxRequestTarget target) {
            if (checkBx.getModelObject() == true) {
                changeableTxt.setEnabled(true);
                target.add(changeableTxt);
            } else {
                compoundModel.setChangeableTxt(null);
                changeableTxt.setEnabled(false);
                target.add(changeableTxt);
            }

        }

        @Override
        protected void onError(AjaxRequestTarget target) {

        }
    };
    checkBx.add(submitBehavior);
    checkBoxForm.add(checkBx, changeableTxt);

    AjaxFormComponentUpdatingBehavior updateBehavior = new AjaxFormComponentUpdatingBehavior(
            "onclick") {
        protected void onUpdate(AjaxRequestTarget target) {
            if (compoundModel.isCheckBx()) {
                changeableTxt.setEnabled(true);
                target.addComponent(changeableTxt);
            } else {
                // compoundModel.setChangeableTxt("");
                changeableTxt.setEnabled(false);
                target.add(changeableTxt);
            }
        }
    };

    form.add(someText);

    FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackPanel");
    form.add(feedbackPanel);

    AjaxSubmitLink submit = new AjaxSubmitLink("submit", form) {

        @Override
        protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
            target.add(form);
        }

        @Override
        protected void onError(AjaxRequestTarget target, Form<?> form) {
            target.add(form);

        }
    };
    add(submit);

}

class CompoundModel implements Serializable {

    private boolean checkBx = false;

    private String someText = null;

    private String changeableTxt = null;

    public boolean isCheckBx() {
        return checkBx;
    }

    public void setCheckBx(boolean checkBx) {
        this.checkBx = checkBx;
    }

    public String getSomeText() {
        return someText;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }

    public String getChangeableTxt() {
        return changeableTxt;
    }

    public void setChangeableTxt(String changeableTxt) {
        this.changeableTxt = changeableTxt;
    }

}
}