Thread[] a = new Thread[this.threadNum];
for(int i = 0; i < this.threadNum; i++){
    a[i] = new Thread(this);
}
// Now `a` is filled with threads.
int count = 0;