FirstClass.java

public final static Object lockObject = new Object();

public static boolean flag = false;

someMethod() {
    sw1.doInbackground() {
    ......
    }

    sw1.done() {
    .....
    }

    synchronized(lockObject){
        flag = true;
        lockObject.notifyAll();
    }
}


SecondClass.java

anotherMethod() {
    sw2.doInbackground() {
        try {
            synchronized(lockObject){
                while (!FirstClass.flag) {
                    FirstClass.lockObject.wait();
                }
                FirstClass.flag = false;
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ......
    }

}