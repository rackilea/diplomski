final ComponentListener customTooltipListener=new ComponentListener() {

        @Override
        public void componentHidden(ComponentEvent e) {
            // whatever you need on this event
        }

        @Override
        public void componentMoved(ComponentEvent e) {
            // whatever you need on this event
        }

        @Override
        public void componentResized(ComponentEvent e) {
            // whatever you need on this event

        }

        @Override
        public void componentShown(ComponentEvent e) {
            // whatever you need on this event

        }
    };          

    JButton button=new JButton("Command") {

        @Override
        public JToolTip createToolTip() {
            //keep default behaviour 
            JToolTip toReturn=super.createToolTip();
            toReturn.addComponentListener(customTooltipListener);
            return toReturn;
        }

    };