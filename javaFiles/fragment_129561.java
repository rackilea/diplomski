dialog.addComponentListener(new ComponentListener() {
    @Override
    public void componentResized(ComponentEvent e) { }

    @Override
    public void componentMoved(ComponentEvent e) { }

    @Override
    public void componentShown(ComponentEvent e) { }

    @Override
    public void componentHidden(ComponentEvent e) {
        if ((int) optionPane.getValue()
                == JOptionPane.YES_OPTION) {
            // do YES stuff...
        } else if ((int) optionPane.getValue()
                == JOptionPane.CANCEL_OPTION) {
            // do CANCEL stuff...
        } else {
            throw new IllegalStateException(
                    "Unexpected Option");
        }
    }
});