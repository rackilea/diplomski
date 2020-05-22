AtomicInteger[] counters = new AtomicInteger[100];

void increment (int idx){
    counters[idx].incrementAndGet();
}

void print(){ 
    StringBuffer buf = new StringBuffer ();
    for( int i=0; i<100; i++;){
         buf.append(","); 
         buf.append(counters[i].get);
    } //End for
    System.out.println(buf.toString());
}