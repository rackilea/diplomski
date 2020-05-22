if(gesture.equals("1")) {
    SwingUtilities.invokeLater() -> {
                mainFrame.getContentPane().remove(mainView);
                mainFrame.invalidate();
                mainFrame.validate();
                mainFrame.repaint();
    });
}