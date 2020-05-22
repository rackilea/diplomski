for (int i = 0 ; i < c.length ; i++)
    {
        c[i].addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                get_locationX(e);
            }
        });
    }