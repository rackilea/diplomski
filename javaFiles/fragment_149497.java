if (toolSet.contains(Tool.PAN)) {
  btn = new JButton(new PanAction(mapPane));
  btn.setName(TOOLBAR_PAN_BUTTON_NAME);
  toolBar.add(btn);
  cursorToolGrp.add(btn);
  toolBar.addSeparator();
}
if (toolSet.contains(Tool.INFO)) {
   btn = new JButton(new InfoAction(mapPaneif(toolSet.contains(Tool.PAN))     {
        btn = new JButton(new PanAction(mapPane));
        btn.setName(TOOLBAR_PAN_BUTTON_NAME);
        toolBar.add(btn);
        cursorToolGrp.add(btn);
        toolBar.addSeparator();
    }
    if (toolSet.contains(Tool.INFO)) {
        btn = new JButton(new InfoAction(mapPane));
        btn.setName(TOOLBAR_INFO_BUTTON_NAME);
        toolBar.add(btn);
        toolBar.addSeparator();
    }));
    btn.setName(TOOLBAR_INFO_BUTTON_NAME);
    toolBar.add(btn);
    toolBar.addSeparator();
}