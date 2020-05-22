private class PaddleHandlerClass {

    public PaddleHandlerClass(JComponent jc) {

        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "up");
        jc.getActionMap().put("up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                rightup = true;
                System.out.println("Up");
            }
        });
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released UP"), "rel up");
        jc.getActionMap().put("rel up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                rightup = false;
            }
        });
    }

}