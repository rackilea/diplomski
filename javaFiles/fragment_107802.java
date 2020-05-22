File file = new File(MY_FILE);

Document document = file.getDocument();
Form form = document.getForm();
form.getFields().get("aAddressLine1").setValue("ADDRESS1_HERE");
form.getFields().get("aAddressLine2").setValue("ADDRESS1_HERE");

file.save(new java.io.File(PATH_HERE), SerializationModeEnum.Incremental);
file.close();