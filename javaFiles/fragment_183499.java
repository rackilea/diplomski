HBox hbox = new HBox(file, closeButton);

HBox.setHgrow(file, Priority.ALWAYS);
HBox.setHgrow(closeButton, Priority.NEVER);

layout.setTop(hbox);
//layout.setRight(closeButton);