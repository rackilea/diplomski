cleanerTask.start();
// Wait for everything to finish.
wt1.join();
wt2.join();
wt3.join();
cleanerTask.join();