BlockingQueue<Data> queue = 
    new  LinkedBlockingQueue<Data>(MAX_BLOCKS_IN_QUEUE_UNTIL_BLOCK );

for (int i=0; i < MAX_DATA_PRODUCERS; i++ ) {
   new Thread( new DataProducer( queue ) ).start();
}

new Thread(DataWriter( queue )).start