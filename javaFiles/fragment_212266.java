public class AMenuStartItem extends Thread implements ActionListener
{
    private VTreePanel m_vtreePanel;

    public AMenuStartItem (int ID, boolean isMenu, String name, AMenu menu, VTreePanel vtreepanel)
    {
        ...

        m_vtreePanel = vtreepanel;  // save the VTreePanel object
    }

    // The thread method that executed when thread is started
    public void run()
    {
        ...

        startWindow(0, cmd);

        ...
    }

    private void startWindow(final int AD_Workbench_ID, final int AD_Window_ID)
    {
        ...

        if (EventQueue.isDispatchingThread()) {
            // This is safe, we're in the EDT
            m_vtreePanel.getTabbedPane().addTab(frame.getTitle(), frame.getAPanel());
            m_vtreePanel.getTabbedPane().invalidate();
            m_vtreePanel.getTabbedPane().repaint();
        } else {
            // This is unsafe, we need to resync with the EDT
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    // Here I perform adding new tab
                    m_vtreePanel.getTabbedPane().addTab(frame.getTitle(), frame.getAPanel());
                    m_vtreePanel.getTabbedPane().invalidate();
                    m_vtreePanel.getTabbedPane().repaint();

                }
            });
        }

        ...
    }

}