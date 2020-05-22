try {
  fss = (FileSaveService)ServiceManager.lookup("javax.jnlp.FileSaveService"); 
} catch (UnavailableServiceException exc) {
  log.append("A problem occurred while accessing the service manager." + newline);
}
if (fss != null) {
  try {
    fileContents = fss.saveFileDialog(null, { "txt" }, is, "JWSFileChooserDemo"); 
  }
  /* Your previous code */
}
/* Your previous code */