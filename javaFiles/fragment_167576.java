CaptachaKey.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "doSomething");
CaptachaKey.getActionMap().put("doSomething",new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            text = CaptachaKey.getText();
            f.setVisible(false);
        }
    });