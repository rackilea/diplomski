/***Code to execute threads***/
Thread[] threads = new Thread[ids.size()];

for (int i = 0; i < ids.size(); i++) {
    JSONObject p = (JSONObject)id.get(i);
    id = p.get("ID").toString();

    threads[i] = new Thread(new DoThread(id));
    threads[i].start();
}

for(int i = 0; i < id.size(); i++) {
    threads[i].join();
}
/*****************************/

public class DoThread implements Runnable {

    private String id;
    public DoThread(String id) {
        this.id = id;
    }

    public void run() {

        //Do Work   

    }
}