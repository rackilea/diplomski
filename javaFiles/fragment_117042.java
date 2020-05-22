boolean produced = false;
// In producer
produced = true;
asd.notifyAll();

// in consumer
while(!produced)
    wait();