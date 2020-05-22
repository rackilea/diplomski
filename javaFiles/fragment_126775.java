final Graphics2D g = dashImg.createGraphics();

EventQueue.invokeLater(new Runnable() {
    public void run () {
        m_dashboard.paintAll(g);
    }
});