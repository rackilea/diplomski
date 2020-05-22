You can check the below code for replacing jpanel without switching jframe.  



contentPanel.removeAll();
        contentPanel.repaint();
        contentPanel.revalidate();
        contentPanel.add(//add your panel here);
        contentPanel.repaint();
        contentPanel.revalidate();