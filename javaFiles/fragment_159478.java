int maxThreads = 2;
int maxValuePerThread = 1000 / maxThreads;
int start = 0;
int end = maxValuePerThread;
PiCalculator pc = new PiCalculator();
Thread[] threads=new Thread[2];
for(int i=0; i<2;i++){
    threads[i]=new Thread(pc.new Pi(start,end));
    threads[i].start();
    start = start + end;
    end = end + maxValuePerThread;
}

for(int i = 0; i < 2; i++) {
    threads[i].join();
}