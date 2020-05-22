jSplitPane.setUI(new BasicSplitPaneUI(){
            @Override
            public BasicSplitPaneDivider createDefaultDivider() {
                return new BasicSplitPaneDivider(this){
                    @Override
                    public void paint(Graphics g) {
                    }
                };
            }
        });