Form hi = new Form("Hi World", BoxLayout.y());

// Replace the "loadingIcon" with the animated gif that you want
Label loadingIcon = new Label(FontImage.createMaterial(FontImage.MATERIAL_3D_ROTATION, "Label", 5));
loadingIcon.getAllStyles().setBgTransparency(0);

Dialog loadingAnimation = new Dialog();
loadingAnimation.setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
Style dlgStyle = loadingAnimation.getDialogStyle();
dlgStyle.setBorder(Border.createEmpty());
dlgStyle.setBgTransparency(0);
loadingAnimation.add(BorderLayout.CENTER, loadingIcon);

Button doTask = new Button("Tap here to do a task");
doTask.addActionListener(l -> {
    loadingAnimation.showModeless();
    Log.p("Some tasks simulated by a sleep of five seconds");
    // Remove the UITimer and add your network tasks
    // Call loadingAnimation.dispose() when the tasks are ended
    new UITimer(() -> {
        loadingAnimation.dispose();
    }).schedule(5000, false, loadingAnimation);
});

hi.add(doTask);
hi.show();