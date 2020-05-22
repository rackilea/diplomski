// TEST 1
int out1X = -50; //x coordinate of the view
int out1Y = -50; //y coordinate of the view
layoutParams.leftMargin = Math.max(0, Math.min(w - 100/*view width*/, out1X))
layoutParams.topMargin = Math.max(0, Math.min(h - 100/*view height*/, out1Y))
// here we have for leftMargin max(0, min(400, -50)) => max(0, -50) => 0 your view won't go further than 0
// for topMargin: max(0, min(700, -50)) => max(0, -50) => 0

// TEST 2
int out2X = 650; //x coordinate of the view
int out2Y = 950; //y coordinate of the view
layoutParams.leftMargin = Math.max(0, Math.min(w - 100, out2X))
layoutParams.topMargin = Math.max(0, Math.min(h - 100, out2Y))
// leftMargin: max(0, min(400, 650)) => max(0, 400) => 400 
// topMargin: max(0, min(700, 950)) => max(0, 700) => 700

// TEST 3
int inX = 50; //x coordinate of the view
int inY = 50; //y coordinate of the view
layoutParams.leftMargin = Math.max(0, Math.min(w - 100, inX))
layoutParams.topMargin = Math.max(0, Math.min(h - 100, inY))
// leftMargin: max(0, min(400, 50)) => max(0, 50) => 50
// topMargin: max(0, min(700, 50)) => max(0, 50) => 50
// in this case we get our original coordinates