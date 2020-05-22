class SimpleAction extends AbstractAction
{
    public void actionPerformed(ActionEvent e)
    {
        EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
        KeyEvent ke = (KeyEvent)queue.getCurrentEvent();
        String keyStroke = ke.getKeyText( ke.getKeyCode() );
        String number = keyStroke.substring(1);
        System.out.println( number );

    }
}