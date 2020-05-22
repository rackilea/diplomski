final Graphics2D g = dashImg.createGraphics();
final SyncObj LOCK = new SyncObj();

EventQueue.invokeLater(new Runnable() {
    public void run () {
        m_dashboard.paintAll(g);
        LOCK.doNotify();
    }
});

LOCK.doWait();
g.dispose();