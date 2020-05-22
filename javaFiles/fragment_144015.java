Threads threads[4] = new Thread[4];

for(int i = 1;i<= 4;i++){
    threads[i] = new Thread(new TestTask(i, list));
    threads[i].start();
}

// to wait that all threads finish..
for(int i = 1;i<= 4;i++){
    threads[i].join();
 }


 while(list.size() != 4){
     // this while loop required so that all threads complete their work
 }