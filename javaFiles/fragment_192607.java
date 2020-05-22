exit.addActionListener(e -> {
        if (e.getActionCommand().equals("exit")){
           int reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Quit?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
        }
});