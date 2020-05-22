// Ex 1 :
class MyJob implements Runnable { 
    public void run() {...} 
}
executeInParallel(() -> new MyJob());
executeInParallel(MyJob::new);