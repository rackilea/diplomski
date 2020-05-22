import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;


class OrderAsc extends Thread {
    int length;
    int iteration;
    SynchronousQueue<ArrayList> st, dr; 
    ArrayList<Integer> vector;
    boolean swapMade;

    OrderAsc( int iteration, SynchronousQueue<ArrayList> st, SynchronousQueue<ArrayList> dr, ArrayList<Integer> vector) throws InterruptedException{
        this.length = vector.size();
        this.st = st;
        this.dr = dr;
        this.vector = vector;
        this.iteration = iteration;
        this.swapMade = false;
    }

    @Override
    public void run(){

        if ( iteration == 0 ){
            try {

                System.out.println("\n  " + iteration  + " put " + vector);

                st.put(vector);

                Thread.currentThread().interrupt();
                return;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else{

            try {
                vector = st.take();
                // System.out.println("\n Take in Thread : " + Thread.currentThread().getName());
                System.out.println(iteration + " take " + vector);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

        } 


        for(int i = 0; i < vector.size() - 1; i++){

            if(vector.get(i) > vector.get(i+1)){
                int tmp = vector.get(i);
                vector.set(i, vector.get(i+1));
                vector.set(i+1, tmp);

                swapMade = true;
            }

        }


        if(swapMade){
                //System.out.println("\n Swap Done in  Thread : " + Thread.currentThread().getName());

            try {
                st.put(vector);

                System.out.println(iteration + " sorted " + vector);

            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }  

        //System.out.println("\n Exiting Thread : " + Thread.currentThread().getName());
        // System.exit(0);

    }


    public static void main(String args[]){
        ArrayList<OrderAsc> orderFilter = new ArrayList<OrderAsc>(5);

        ArrayList<Integer> vector = new ArrayList<Integer>(6);
        vector.add(4);
        vector.add(1);
        vector.add(3);
        vector.add(5);
        vector.add(6);
        vector.add(2);


        System.out.println("\n Unsorted Array " + vector + "\n\n");

        int n = vector.size();

        //vector.add(1);
        //vector.add(5);

        SynchronousQueue<ArrayList> st1 = new SynchronousQueue<ArrayList>();
        SynchronousQueue<ArrayList> dr1 = new SynchronousQueue<ArrayList>();

        for(int i = 0; i < n ; i++){
            try {

                orderFilter.add(i, new OrderAsc(i, st1, dr1, vector));

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //st1 = dr1;
            //dr1 = new SynchronousQueue<ArrayList>();                    
        }

        for(int i=0; i < n - 1; i++){
            //orderFilter.get(i).setDaemon(true);
             orderFilter.get(i).start();
        }


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("\n Voila Thanks Threads and the  Sorted Array Is ");

        for(int i = 0; i < vector.size(); i++){
            System.out.print(" " + vector.get(i) +  " ");
        }   

    }

}