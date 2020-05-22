@Override
    public void mouseReleased(MouseEvent e) {
        JComponent c = (JComponent) e.getSource();
        if (c.getTopLevelAncestor().getBounds().contains(e.getLocationOnScreen())) {
            // do nothing, the drop point is the same frame
        } else {
            DragTabFrame dtf = getTargetFrame(e.getLocationOnScreen());
            if (dtf == null) {
                dtf = new DragTabFrame();
                dtf.init();
                dtf.setLocation(e.getLocationOnScreen());
            }// else {
            DragTabFrame fromFrame = dragTabManager.getCurrentFrame();
            fromFrame.removeTabComponent(c);
            JTabbedPane tp = fromFrame.getTabbedPane();
            if (tp.getTabCount() == 0) {
                fromFrame.setVisible(false);
                fromFrame.dispose();
            } 
            //}
            dtf.addTabComponent(dragTabManager.getCurrentTitle(), c);
            dtf.pack();
            dtf.setVisible(true);
        }
    }