JTextArea _area = new JTextArea();
//        _area.setBounds(10, 10, 400, 250);
        add(_area);

        JScrollPane scroller = new JScrollPane(_area);
        scroller.setBounds(10, 10, 400, 250);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroller);