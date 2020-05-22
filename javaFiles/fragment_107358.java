public class WorkerThread implements Runnable {

    private Service service;

    public WorkerThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        // code to query webservice and extract data...

        service.saveToDbMethod(data);
    }
}