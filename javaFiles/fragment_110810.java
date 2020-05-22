//Threads use this ...
private class threadILoop implements Runnable {
    protected int start, end, j, k;
    public threadILoop(int start,int end,int j,int k){
        this.start = start;
        this.end = end;
        this.j = j;
        this.k = k;
    }
    public void run() {
        for (int z = start; z < end; z++) {    
            int zxj = z ^ j;
            if(zxj > z){
                if((z&k) == 0 && (data[z] > data[zxj]))
                    swap(z, zxj);
                if((z&k) != 0 && (data[z] < data[zxj]))
                    swap(z, zxj);
            }
            // Wait moved from here
        }
        // To here (outside the inner loop)
        try{barrier.await();}
        catch (InterruptedException ex) { return; }
        catch (BrokenBarrierException ex) {return; }
    }
}