public void paintComponent(Graphics page) {
     super.paintComponent(page);

     page.setColor(Color.black);
     page.fillOval(bill.x, bill.y, 50, 50);
 }