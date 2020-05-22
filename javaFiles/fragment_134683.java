sp.setUI(new BasicSplitPaneUI() {
    @Override
    public BasicSplitPaneDivider createDefaultDivider() {
        return new BasicSplitPaneDivider(this) {
            private static final long serialVersionUID = -6000773723083732304L;

            @Override
            public void paint(Graphics g) {
                //Divider gets no painting
            }
        };
    }
});