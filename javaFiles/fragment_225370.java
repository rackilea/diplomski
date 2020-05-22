JPanel newPanel = new JPanel();

JPanel panel2 new JPanel(new BorderLayout());
panel2.add(newPanel, BorderLayout.WEST);
panel2.add(panel1, BorderLayout.CENTER);

             panel2
+---------------+--------------------------------+
|               |                                |
|               |                                |  
|               |          Image Label           |
|    newPanel   |                                |
|               +----------------+---------------+
|               |      jbt1      |      jbt2     |   
+---------------+----------------+---------------+