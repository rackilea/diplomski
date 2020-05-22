public class App {
    public static void main(String[] args) {
        FooQueue q = new FooQueue();
        FooQueue2 q2 = new FooQueue2();

        q.add(FooQueue::do1, new FooItem());
        // Equals to:
        q.add((qInstance, item) -> qInstance.do1(item), new FooItem());

        // q.add(FooQueue2::do1, new FooItem());  // not compile
    }
}

class FooQueue {
    void do1(FooItem item) {
        System.out.println("FooQueue:do1");
    }

    void add(BiConsumer<FooQueue, FooItem> func, FooItem wi) {
        System.out.println("FooQueue:addWorkItem");
        func.accept(this, wi);
    }
}

// class that pretends to be FooQueue
class FooQueue2 {
    void do1(FooItem item) {
        System.out.println("FooQueue2:do1");
    }
}

class FooItem {
}