@Service   
public class CheckoutService {

    @Async
    public void checkout(List<ProcessLog> list) throws InterruptedException {
        process = processUtil.start(getHome(), job);
        list.add(process);
        preprocess();
        execute();
        postprocess();
        list.remove(process);
        processUtil.end(process);
    }
}