Thread myThreads[] = new Thread[argsize];
for (int j = 0; j < argSize; j++) {
    myThreads[j] = new Thread(new wThreads(j));
    myThreads[j].start();
}
for (int j = 0; j < argSize; j++) {
    myThreads[j].join(); //todo add catch exception
}