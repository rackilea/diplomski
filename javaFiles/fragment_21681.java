int temp = View.TOTAL_LOOPS; // in thread 1
int temp = View.TOTAL_LOOPS; // in thread 2
int temp2 = temp + 1; // in thread 1
View.TOTAL_LOOPS = temp2; // in thread 1
int temp2 = temp + 1; // in thread 2
View.TOTAL_LOOPS = temp2; // in thread 2