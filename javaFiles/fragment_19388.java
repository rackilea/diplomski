KeyListener listener = new KeyListener() {
        @Override
        public void componentKeyPress(ComponentEvent event) {
            if(event.getKeyCode()==13)
            {
                addPortlet(requiredHeight.getValue().intValue());
            }
            super.componentKeyPress(event);
        }

    };
    requiredHeight.addKeyListener(listener);