@DialogFactory("my-dialog")
public void myDialog(DialogBuilder myDialog) {
  TabBuilder settings = myDialog.addTab("Main page settings");
  settings.addEdit("title", "Title", "The HTML page title");
  FckEditorDialog fedContent = settings.addFckEditor("content", "Content", "The Content"); 
  fedContent.setConfig(FckEditorDialog.PARAM_IMAGES, true);
}