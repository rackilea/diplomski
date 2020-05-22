TLVPusher implements Runnable
    OutputStream out;
    Queue<TLVMessage> messages;
    run() {
        while(true) {
            //poll and write front of queue to out (INCLUDING value.length!)
        }
    }