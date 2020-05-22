public class Test12 {

public static void main(String[] args) {
    Thread1 t1=new Thread1();
    Thread2 t2=new Thread2();


}

}

class Thread1 implements Runnable {

public Thread1() {
    Thread t = new Thread();
    t.start();
}

@Override
public void run() {
    try {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }

        }

    } catch (Exception e) {

    }
}
}

class Thread2 implements Runnable {

public Thread2() {
    Thread t = new Thread(this);
    t.start();

}

@Override
public void run() {
    try {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }

        }

    } catch (Exception e) {

    }
}

}