String actionUrl = getActionURLFromServer();
NamedFrame frame = new NamedFrame("iframe");
frame.setSize("400px","600px");
final FormPanel form = new FormPanel(frame);
form.setEncoding(FormPanel.ENCODING_MULTIPART);
form.setMethod(FormPanel.METHOD_POST);
form.setAction(actionUrl);
FileUpload upload = new FileUpload();
upload.setName("myFile");
upload.addChangeHandler(new ChangeHandler() {
  void onChange(ChangeEvent event) {
    form.submit();
  }
});
form.setWidget(upload);
RootPanel.get().add(form);
RootPanel.get().add(frame);