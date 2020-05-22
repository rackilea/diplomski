public  class fragmentFragment extends FormFragment {
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String GENDER = "gender";
    public static final String HOBBIES = "hobbies";

    public boolean validate() {
        getFormController().resetValidationErrors();
        if (getFormController().isValidInput()) {
            Object firstName = getModel().getValue(FIRST_NAME);
            Object lastName = getModel().getValue(LAST_NAME);
            Object gender = getModel().getValue(GENDER);
            Object favColor = getModel().getValue(HOBBIES);

            String msg = "First name: " + firstName + "\n"
                    + "Last name: " + lastName + "\n"
                    + "Gender: " + gender + "\n"
                    + "Hobbies: " + favColor + "\n";
            MessageUtil.showAlertMessage("Field Values", msg, getActivity());
        } else {
            getFormController().showValidationErrors();
        }
        return true;
    }


    @Override
    public void initForm(FormController controller) {
        Context ctxt = getContext();
        FormSectionController section = new FormSectionController(ctxt, "Personal Info");
        section.addElement(new EditTextController(ctxt, FIRST_NAME, "First name"));
        section.addElement(new EditTextController(ctxt, LAST_NAME, "Last name"));


        controller.addSection(section);
    }
}