Button saveButtonVolume = new Button("save");
Button saveButtonResolution = new Button("save");

// ...

saveButtonVolume.setOnAction(e -> Platform.exit());
saveButtonResolution.setOnAction(e -> Platform.exit());

// ...

resolutionLayout.getChildren().addAll(resolutionlabel, saveButtonResolution, optionsButtonResolution);
volumeLayout.getChildren().addAll(volumelabel, saveButtonVolume, optionsButtonVolume);