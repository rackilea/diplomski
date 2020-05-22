Component source = (Component) evt.getSource();
MyPanel panel = (MyPanel) source.getParent()
                                .getParent()
                                .getParent()
                                .getParent()
                                .getParent();