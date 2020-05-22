public static void main(String[] args)
    throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
{
    JFrame frame = new GameFrame();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(800, 600);

    frame.setVisible(true);
}

public static class GameFrame extends JFrame
{
    public GameFrame()
    {
        super();
        enableEvent(AWTEvent.KEY_EVENT_MASK | AWTEvent.WINDOW_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK);
    }

    //override processEvent which is called in Component class every time an event happens
    @Override
    public void processEvent(AWTEvent event)
    {
        System.out.println("override " + event);
        super.processEvent(event);
    }

}