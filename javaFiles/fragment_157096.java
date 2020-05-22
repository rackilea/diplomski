table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {

     String symbol=(String)table.getModel().getValueAt(table.rowAtPoint(e.getPoint()),0);

                    }

            } 
    }