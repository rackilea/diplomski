import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Store {

    public static Object sync = new Object();

    public static void main(String[] args) {
        AtomicInteger tasksList = new AtomicInteger(7);
        Runnable boss = () -> {
            System.out.println("Boss: Good morning.");
            List<Runnable> employeeList = generateEmployeesList(5, tasksList);
            for (Runnable employee : employeeList) {
                Thread t = new Thread(employee);
                t.start();
            }

            synchronized (sync) {
                while(tasksList.get() > 0) {
                    try {                        
                        System.out.println("Work more!");
                        tasksList.incrementAndGet();
                    } finally {
                        try {
                            sync.wait(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            System.out.println("Boss: Time to go home.");
        };

        System.out.println("= Starting =");
        boss.run();

    }

    public static List<Runnable> generateEmployeesList(int amountOfEmployees, AtomicInteger tasksList){
        List<Runnable> employeeList = new ArrayList<Runnable>();
        for (int i = 0; i < amountOfEmployees; i++) {
            employeeList.add(createEmployee(i+1, tasksList));
        }
        return employeeList;
    }

    public static Runnable createEmployee(int employeeNumber, AtomicInteger tasksList) {
        return () -> {
            System.out.println("Thread #" + (employeeNumber) + " Started. Missing tasks: " + tasksList.get());
            synchronized (sync) {
                while (tasksList.get() > 0) {
                    try {
                        System.out.println("Thread #" + (employeeNumber) + ". Task completed: "
                                + tasksList.decrementAndGet() + " tasks left.");
                    } finally {
                        try {
                            sync.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            System.out.println("Thread #" + (employeeNumber) +": Finished.");
        };
    }
}