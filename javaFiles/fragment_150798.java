private class taskPerformer implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent captureEvent) {
        if(captureEvent.getSource() == wS.getCaptureButton()) {
            if (wS.getCaptureButton().isSelected()) {
                t.start();
            } else {
                t.stop();
            }
        }

        if(captureEvent.getSource() == t) {
            getContentPane().setBackground(randomColor());
            revalidate();
            repaint();
        }
    }
}