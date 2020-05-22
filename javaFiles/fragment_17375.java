void createPage0() {    
    FormToolkit toolkit = new FormToolkit(composite.getDisplay());
    Form form = toolkit.createForm(composite);
    form.setText("Test Viewer");

    toolkit.decorateFormHeading(form);

    int index = addPage(composite);
    setPageText(index, "editor1");
}