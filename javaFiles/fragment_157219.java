package com.myapp;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.pool2.BaseKeyedPooledObjectFactory;
import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class BalancingServlet extends javax.servlet.http.HttpServlet {

    private final WorkersPool workersPool;

    public BalancingServlet() {
        workersPool = new WorkersPool(new WorkersFactory());
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Balancing");

        String language = request.getParameter("language");
        String someOtherParam = request.getParameter("other");
        WorkerParameters workerParameters = new WorkerParameters(language, someOtherParam);

        String requestSpecificParam1 = request.getParameter("requestParam1");
        String requestSpecificParam2 = request.getParameter("requestParam2");

        try {
            WorkerInstance workerInstance = workersPool.borrowObject(workerParameters);
            workerInstance.handleRequest(requestSpecificParam1, requestSpecificParam2);
            workersPool.returnObject(workerParameters, workerInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

class WorkerParameters {
    private final String workerLangauge;
    private final String someOtherParam;

    WorkerParameters(String workerLangauge, String someOtherParam) {
        this.workerLangauge = workerLangauge;
        this.someOtherParam = someOtherParam;
    }

    public String getWorkerLangauge() {
        return workerLangauge;
    }

    public String getSomeOtherParam() {
        return someOtherParam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkerParameters that = (WorkerParameters) o;

        return Objects.equals(this.workerLangauge, that.workerLangauge) && Objects.equals(this.someOtherParam, that.someOtherParam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerLangauge, someOtherParam);
    }
}

class WorkerInstance {
    private final Thread thread;
    private WorkerParameters workerParameters;

    public WorkerInstance(final WorkerParameters workerParameters) {
        this.workerParameters = workerParameters;

        // launch the process here   
        System.out.println("Spawing worker for language: " + workerParameters.getWorkerLangauge());

        // use commons Exec to spawn your process using command line here

        // something like


        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String line = "C:/Windows/notepad.exe" ;
                    final CommandLine cmdLine = CommandLine.parse(line);

                    final DefaultExecutor executor = new DefaultExecutor();
                    executor.setExitValue(0);
//                    ExecuteWatchdog watchdog = new ExecuteWatchdog(60000); // if you want to kill process running too long
//                    executor.setWatchdog(watchdog);

                    int exitValue = executor.execute(cmdLine);
                    System.out.println("process finished with exit code: " + exitValue);
                } catch (IOException e) {
                    throw new RuntimeException("Problem while executing application for language: " + workerParameters.getWorkerLangauge(), e);
                }


            }
        });

        thread.start();


        System.out.println("Process spawned for language: " + workerParameters.getWorkerLangauge());


    }

    public void handleRequest(String someRequestParam1, String someRequestParam2) {
        System.out.println("Handling request for extra params: " + someRequestParam1 + ", " + someRequestParam2);

        // communicate with your application using parameters here

        // communcate via tcp or whatever protovol you want using extra parameters: someRequestParam1, someRequestParam2


    }

    public boolean isRunning() {
        return thread.isAlive();
    }


}

class WorkersFactory extends BaseKeyedPooledObjectFactory<WorkerParameters, WorkerInstance> {

    @Override
    public WorkerInstance create(WorkerParameters parameters) throws Exception {
        return new WorkerInstance(parameters);
    }

    @Override
    public PooledObject<WorkerInstance> wrap(WorkerInstance worker) {
        return new DefaultPooledObject<WorkerInstance>(worker);
    }

    @Override
    public void activateObject(WorkerParameters worker, PooledObject<WorkerInstance> p)
            throws Exception {
        System.out.println("Activating worker for lang: " + worker.getWorkerLangauge());

        if  (! p.getObject().isRunning()) {
            System.out.println("Worker for lang: " + worker.getWorkerLangauge() + " stopped working, needs to respawn it");
            throw new RuntimeException("Worker for lang: " + worker.getWorkerLangauge() + " stopped working, needs to respawn it");
        }
    }

    @Override
    public void passivateObject(WorkerParameters worker, PooledObject<WorkerInstance> p)
            throws Exception {
        System.out.println("Passivating worker for lang: " + worker.getWorkerLangauge());
    }

}

class WorkersPool extends GenericKeyedObjectPool<WorkerParameters, WorkerInstance> {

    public WorkersPool(KeyedPooledObjectFactory<WorkerParameters, WorkerInstance> factory) {
        super(factory);
    }
}