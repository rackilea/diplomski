public static void main(String[] args)
{
    final JFrame frame = new JFrame();

    Application app = Application.getApplication();
    app.addAppEventListener(new AppForegroundListener() {

        @Override
        public void appMovedToBackground(AppForegroundEvent arg0)
        {
            System.out.println("appMovedToBackground");
        }

        @Override
        public void appRaisedToForeground(AppForegroundEvent arg0)
        {
            System.out.println("appRaisedToForeground");
            frame.setVisible(true);
        }

    });

    app.addAppEventListener(new AppReOpenedListener() {
        @Override
        public void appReOpened(AppReOpenedEvent arg0)
        {
            System.out.println("app reoponed");
            frame.setVisible(true);
        }
    });

    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
}