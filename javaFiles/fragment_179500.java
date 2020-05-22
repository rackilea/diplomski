Action action = new AbstractAction()
{
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("do nothing");
    }
};

JPanel content = (JPanel)frame.getContentPane();
String key = "F10";
KeyStroke f10 = KeyStroke.getKeyStroke( key );
frame.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(f10, key);
frame.getRootPane().getActionMap().put(key, action);