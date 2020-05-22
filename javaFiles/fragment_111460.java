/* 
 * mostly based on 
 * http://download.oracle.com/javase/6/docs/api/java/util/concurrent/Exchanger.html 
 */
package so_6936111;

import java.util.concurrent.Exchanger;

public class WorkflowDemo {

    public static void main(String[] args) {
        Pipeline pipeline = new Pipeline();
        pipeline.start();
    }
    // ----------------------------------------------------------------
    // Pipeline
    // ----------------------------------------------------------------

    public static class Pipeline {

        /** exchanger for messages */
        Exchanger<Message> exchanger = new Exchanger<Message>();

        /* the two message instances that are passed back and forth */
        Message msg_1 = new Message();
        Message msg_2 = new Message();

        /** startups the pipeline */
        void start() {
            new Thread(new WorkerR()).start();
            new Thread(new WorkerL()).start();
        }


        /** Message objects are passed between workflow threads */
        public static class Message {
            private Object content;
            public Object getContent() { return content; }
            public void setContent(Object c) { this.content = c; }
        }


        /** WorkerR is at the head of the pipeline */
        class WorkerR implements Runnable {
            public void run() {
                Message message = msg_1;
                try {
                    while (true) {
                        Object data = doSomeWork();
                        message.setContent(data);
                        message = exchanger.exchange(message);
                    }
                } catch (InterruptedException ex) { ex.printStackTrace();}
            }
            /** 
             * let's pretend this is where you get your 
             * initial data and do some work
             */
             private Object doSomeWork() {
                return String.format("STEP-1@t:%d", System.nanoTime());
             }
        }

        /** WorkerL is at the tail of the pipeline */
        class WorkerL implements Runnable {
            public void run() {
                Message message = msg_2;
                try {
                    while (true) {
                        message = exchanger.exchange(message);
                        Object data = doPostProcessing(message.getContent());
                        System.out.format("%s\n", data);
                    }
                } catch (InterruptedException ex) { ex.printStackTrace();}
            }

            /**
             * Let's pretend this is where the 2nd step of the workflow.
             */
            private Object doPostProcessing(Object data) {
                return String.format("%s | STEP-2@t:%d", data, System.nanoTime());
            }
        }
    }
}