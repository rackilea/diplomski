JFrame f = new JFrame ("Calculus");
JPanel panel = new JPanel();
Test t= new Test();
panel.add(t);// add the component you want to be scrolling to the scroll pane.
JScrollPane scrollFrame = new JScrollPane(panel, 
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
f.add(scrollFrame);