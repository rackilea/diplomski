public void someGreatTestName() {
    FormName formName = ...; // either create a new, fake one or mock one (see below)
    JSONObject object = new MyClass(formName).getListOfAllForms();

    // now test that the object is correct
}