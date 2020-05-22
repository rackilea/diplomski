JScrollPane scroller = new JScrollPane(mainPane);
scroller.setPreferredSize(new Dimension(200,200));
// ... etc
scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI()
    {   
        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override    
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton jbutton = new JButton();
            jbutton.setPreferredSize(new Dimension(0, 0));
            jbutton.setMinimumSize(new Dimension(0, 0));
            jbutton.setMaximumSize(new Dimension(0, 0));
            return jbutton;
        }
    });