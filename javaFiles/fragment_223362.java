JTextPane tp = new JTextPane() {

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return getUI().getPreferredSize(this).width
                        <= getParent().getSize().width;
    }

};