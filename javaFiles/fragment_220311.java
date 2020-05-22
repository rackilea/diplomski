Thread thread;
    ImportRunnable importRun;
public void startImport(){
            importRun = new ImportRunnable();
    thread = new Thread(importRun);
    thread.start();
}
    public void stopThread(){
         importRun.setActive(false);
         thread.join();
    }
public class ImportRunnable implements Runnable{
            boolean active;
            public ImportRunnable(){this.active=true;}
    public void run(){
        doImport();
    }
    public void setActive(boolean active){this.active=active;}
    void doImport(){
                while(active){
                    //do import stuff
                }
            }
}