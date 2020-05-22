// Ex 2 :
class MyJobWithParams implements Runnable {
    public MyJobWithParams(String param1, int param2) { ... }
    public void run() {...} 
}
executeInParallel( () -> new MyJobWithParams("Hello",42) );
// You cannot use method references here