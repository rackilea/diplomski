Thread[] threads = new Thread[num];

for(int i = 1; i <= num; i++){     //p1 is a runnable.
        Thread t = new Thread(p1, "t"+ Integer.toString(i));
        threads[i-1] = t;
        t.start();
} 

while(!allThreadsCompleted(threads)) {
 // do some of your code here
}

public static boolean allThreadsCompleted(Thread[] threads) {
    for(int i = 0; i < threads.length; i++) {
        if(threads[i].getState()!=Thread.State.TERMINATED)
            return false;
    }
    return true;
}