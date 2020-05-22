@Override
public void run() {
    while (getLink());
}

private synchronized boolean getLink(){
    String threadName = Thread.currentThread().getName();
    System.out.println(threadName + " printed " + test.indexOf(test.size() - 1));
    if(!test.isEmpty()){
        test.remove(0);
    }
    return !test.isEmpty()
}