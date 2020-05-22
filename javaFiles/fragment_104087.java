SimViewBuilder  builder = new SimViewBuilder(jframe, jpanel);

if (model.simRolls != null) {
    builder = builder.actionButton("Next", GroupAlignment.TRAILING);
}

if (inputEvent.getSource == outputBtn) {
    builder = builder.outputLabel(model.simRolls, GroupAlignment.CENTER);
}

if (model.testType.equals("Success")) {
    builder = builder.testLabel("SUCCESS TEST OUTPUT", GroupAlignment.LEADING);
}

... // add more if statements for other features and configure the builder accordingly

// finally, build it
SimView outputScreen = builder.build();