left.start(); 
right.start();
// left and right threads are running in the background...
// we join with them so we can make sure they have finished
// and we can sync with their memory updated of x1 and x2
left.join();
right.join();
x = x1 + x2;