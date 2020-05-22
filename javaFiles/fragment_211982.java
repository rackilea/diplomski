public void paintComponent(Graphics page) {
  super.paintComponent(page);
  c = 0;  // each time paintComponent starts, c should be 0
  for (Point spot : pointList) {
     page.setColor(colors[c]);
     page.fillRect(spot.x - sizes[pointList.size()], spot.y
           - sizes[pointList.size()], sizes[pointList.size()] * 2,
           sizes[pointList.size()] * 2);
     c++;  // but within the for loop, it should increment.
  }
  // .... etc