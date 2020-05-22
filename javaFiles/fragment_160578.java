public Demo() {
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        JDesktopPane df = new JDesktopPane();
        DesktopManager dm = df.getDesktopManager();
        df.setDesktopManager(new DefaultDesktopManager(){
               public void dragFrame(JComponent f, int newX, int newY) {
                  super.dragFrame(f, newX, 5);
               }

        });
        JInternalFrame jif = new JInternalFrame("test ");
        jif.setLocation(5, 5);
        jif.setSize(150,100);
        jif.setVisible(true);
        df.add(jif);
        frame.setContentPane(df);
        frame.setVisible(true);
}