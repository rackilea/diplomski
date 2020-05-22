SampleAction a = new SampleAction("foo", null);

JButton b = new JButton(a);
b.getActionMap().put("bar", a);
b.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "bar");

 class SampleAction extends AbstractAction {

        public SampleAction(String text, Icon icon) {
            super(text, icon);

            putValue(Action.ACTION_COMMAND_KEY, text);//'foo' will be printed when button clicekd/F1 pressed
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action [" + e.getActionCommand() + "] performed!");
        }
    }