myDateChooser.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("date")) {
                    dateString = new SimpleDateFormat("yyyy-MM-dd").format(myDateChooser.getDate());
                }
            }
        });