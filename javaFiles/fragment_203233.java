HorizontalFieldManager manager = new HorizontalFieldManager(USE_ALL_WIDTH);
    BasicEditField editField = new BasicEditField("Test", ""){
        protected void layout(int width, int height) {
            super.layout(width, height);
            setExtent(140, getPreferredHeight());
        }
    };
    manager.add(editField);
    manager.add(new ButtonField("button1"));
    manager.add(new ButtonField("button2"));
    add(manager);