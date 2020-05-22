getRibbon().addPropertyChangeListener(new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals("minimized")){
                getRibbon().setMinimized(false);
            }
        }
    });