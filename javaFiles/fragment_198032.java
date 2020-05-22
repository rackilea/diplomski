public class MyTask {

    @Inject
    MyBean myBean;

    MyCallable callable = new MyCallable();

    public Callable getCallable() {
        return callable;
    }

    private class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {

            System.out.println("MyTask called");
            myBean.print();
            return "Task called";
        }
    }
}    

public class TestBean {

    // ...

    MyTask task = myTaskInstance.get(); 
    tasks.add(task.getCallable())

    // ...
}