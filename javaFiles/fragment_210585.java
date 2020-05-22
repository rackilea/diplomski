import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class QueueingDatabaseProcessingExample {

    public static void main(String[] args) throws InterruptedException {
        QueueingDatabaseProcessingExample a = new QueueingDatabaseProcessingExample();
        a.doTheWork();
    }

    private void doTheWork() throws InterruptedException {

        BlockingQueue<TcpCommunicatorUnitOfWork> blockingQueue = new ArrayBlockingQueue(1000);

        // add work to queue as needed
        blockingQueue.put(new TcpCommunicatorUnitOfWork("device id", 40.7143528, -74.0059731, 10));  // blocks if queue is full


        Connection connection;

        // get connection to the database from database pool

        // process requests one by one sequentially
        while (true) {
            TcpCommunicatorUnitOfWork tcpCommunicatorUnitOfWork = blockingQueue.take(); // blocks if queue is empty

            proccess(tcpCommunicatorUnitOfWork);
        }
    }

    private void proccess(TcpCommunicatorUnitOfWork tcpCommunicatorUnitOfWork) {
        // do queries, inserts, deletes to database
    }

}


/**
 * this class should have all the information needed to query/update the database
 */
class TcpCommunicatorUnitOfWork {

    private final String deviceId;
    private final double latitude;
    private final double longitude;
    private final int seaLevel;

    public TcpCommunicatorUnitOfWork(String deviceId, double latitude, double longitude, int seaLevel) {
        this.deviceId = deviceId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.seaLevel = seaLevel;
    }


}