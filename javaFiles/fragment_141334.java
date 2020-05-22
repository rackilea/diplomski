private void inUrFace(){
Dialog<Void> dialog = new Dialog<>();
dialog.initModality(Modality.WINDOW_MODAL);
dialog.initOwner(stage);//stage here is the stage of your webview
dialog.initStyle(StageStyle.TRANSPARENT);
Label loader = new Label("LOADING");
loader.setContentDisplay(ContentDisplay.DOWN);
loader.setGraphic(new ProgressIndicator());
dialog.getDialogPane().setGraphic(loader);
DropShadow ds = new DropShadow();
ds.setOffsetX(1.3); ds.setOffsetY(1.3); ds.setColor(Color.DARKGRAY);
dialog.getDialogPane().setEffect(ds);
dialog.showAndWait();}