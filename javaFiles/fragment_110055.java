public static void upload(@Required File sprocketFile) {
try {           
  if (sprocketFile == null || validation.hasErrors()) {
    validation.addError("Upload Error", "Please select a sprocket to upload", sprocketFile);
    params.flash();
    validation.keep();                          
    index();
}