A[i].getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK),"0");
        A[i].getActionMap().put(String.valueOf("0"),new AbstractAction() {
            public void actionPerformed(ActionEvent J) {
                B[0].doClick();
            }
        });
        A[i].getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0),"1");
        A[i].getActionMap().put(String.valueOf("1"),new AbstractAction() {
            public void actionPerformed(ActionEvent J) {
                B[1].doClick();
            }
        });