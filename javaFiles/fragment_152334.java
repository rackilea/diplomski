public Thread newThread(Runnable r) {
    if(jsfThread != null){
        return jsfThread;
    }else{
        return new Thread(r);
    }
}