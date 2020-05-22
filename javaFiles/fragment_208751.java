SampleAction a = new SampleAction("foo", null);

  JButton b = new JButton(a);
  b.getActionMap().put("bar", a);
  b.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "bar");

class SampleAction extends AbstractAction
{
    public SampleAction(String text, Icon icon) {
    super(text, icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    System.out.println("Action [" + ((JButton)e.getSource()).getActionCommand() + "] performed!");
    }
}