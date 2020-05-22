RowAndThetaThread[] thread_arr = new RowAndThetaThread[LENGTH];
for(int i = 0; i < thread_arr.length; i++) {
    thread_arr[i] = new RowAndThetaThread();
}
thread_semaphore = new Semaphore(thread_arr.length, false);
for (int i=0; i<border_que.arr.length; i++) {
   thread_arr[i].lol(); // NullPointerException happens here
}