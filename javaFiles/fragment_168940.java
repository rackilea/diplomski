SwingUtilities.invokeLater(new Runnable(){
    @Override
    public void run(){
        JOptionPane.showMessageDialog(
            Utils.getActiveFrame(),
            msg, 
            "Error", 
            JOptionPane.ERROR_MESSAGE,
            errorIcon);
    }
});