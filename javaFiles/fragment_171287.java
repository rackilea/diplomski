import java.util.*;
public class HashMapRaceCondition2 {
    public static void main(String[] args) throws Exception {
        class MyClass {
            int value;

            MyClass(int value) {
                this.value = value;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                MyClass myClass = (MyClass) o;

                if (value != myClass.value) return false;

                return true;
            }

            @Override
            public int hashCode() {
                return 42;
            }

            @Override
            public String toString() {
                return "MyClass{" +
                        "value=" + value +
                        '}';
            }
        }  // MyClass

        Map<MyClass,Integer> map = new HashMap<>();

        Thread t1 = new Thread(() -> {
            for (int i =0; i < 1000; ++i) {
                map .put(new MyClass(i), i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 2000; i < 3000; ++i) {
                map.put(new MyClass(i), i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(map.size());
    }
}