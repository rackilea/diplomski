buttons.setFocusTraversalPolicyProvider(true);
buttons.setFocusTraversalPolicy(new LayoutFocusTraversalPolicy() {
  @Override public Component getDefaultComponent(Container focusCycleRoot) {
    ButtonModel selection = bg.getSelection();
    for (Component c: focusCycleRoot.getComponents()) {
      JRadioButton radioBtn = (JRadioButton) c;
      ButtonModel loopModel = radioBtn.getModel();
      if (loopModel == selection) {
        return radioBtn;
      }
    }
    return super.getDefaultComponent(focusCycleRoot);
  }
});