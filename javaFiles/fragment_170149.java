SwingUtilities.invokeLater(new Runnable() {

    @Override
    public void run() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // If Nimbus is not available, you can set the GUI to 
            // another look and feel.
        }
    }
});