class MyClass implements Runnable {

int id = -1;

public synchronized int getId() {
 if(id == -1) {
 id = SomeSingleTon.getNextId();
 }
 return id;
}


public run() ...
//etc
}