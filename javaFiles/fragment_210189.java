public void mousePressed(MouseEvent e){
        if(node.contains(e.getPoint())){
            preX = node.getBounds().x-e.getX();
            preY = node.getBounds().y-e.getX(); // <- That's the bad guy.
            offset = new Point(preX, preY);
        }
    }