if ((frame.getParent() != null) && !componentListenerAdded) {
            f.getParent().addComponentListener(componentListener);
            componentListenerAdded = true;
        } else if ((newValue == null) && componentListenerAdded) {
            if (f.getParent() != null) {
                f.getParent()
                        .removeComponentListener(componentListener);
            }
            componentListenerAdded = false;
        }