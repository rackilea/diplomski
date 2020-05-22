/* A queue to trick the executor into blocking until a Thread is available when offer is called */
public class SpecialSyncQueue<E> extends SynchronousQueue<E> {
    @Override
    public boolean offer(E e) {
        try {
            put(e);
            return true;
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            return false;
        }
    }
}

ExecutorService executor = new ThreadPoolExecutor(cores, cores, new SpecialSyncQueue(), ...);
void pruneNonPrimes() {
    //...
    while(p <= (int)(Math.sqrt(N))) {
        executor.execute(new RemoveNonPrime(f, p));
        //get the next prime
        p++;
        while(p<=(int)(Math.sqrt(N))&&f[p]==0)p++;
    }


    //count primes
    int total = 0;
    System.out.println();

    for(int j=0; j<f.length;j++){
        if(f[j]!=0){
            total++;
        }
    }
    System.out.printf("Number of primes up to %d = %d",f.length,total);
}



class RemoveNonPrime extends Runnable {
    int k;
    int arr[];

    public RemoveNonPrime(int arr[], int k){
        this.arr = arr;
        this.k = k;
    }

    public void run(){
        int j = k*k;
        while(j<arr.length){
            if(arr[j]%k == 0)arr[j]=0;
            j+=k;
        }
    }
}