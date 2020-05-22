public class MyThread implements Callable<List<String>> {

    @Override
    public List<String> call() throws Exception {
        List<String> list = new ArrayList(2);
        Thread.sleep(2000);
        list.add("Object2");
        Thread.sleep(2000);
        list.add("Object3");
        Thread.sleep(2000);
        return list;
    }
}