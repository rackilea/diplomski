try {
    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        System.out.println("LAF: " + info.getName());
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            //break;
        }
    }
} catch (ClassNotFoundException | InstantiationException
    | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
}