getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "doSomething");
  getActionMap().put("doSomething",new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.out.println("profit");
        }
    });