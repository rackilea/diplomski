public void foo(){
    synchronized (this) {
        if(critical condition){
            bar();  // can influence the above condition
        }
        baz(); // can influence the above condition
    }
}