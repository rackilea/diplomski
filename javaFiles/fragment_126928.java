sp.focusedProperty().addListener(new InvalidationListener() {               
            @Override
            public void invalidated(Observable observable) {
                if (lastFocusedNode != null) {
                    lastFocusedNode.requestFocus();
                }
            }
        });