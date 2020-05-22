int counter;
int newCounter;
do {
    counter = clientCounter.get();
    newCounter = counter < Integer.MAX_VALUE ? counter + 1 : 1;
} while (!clientCounter.compareAndSet(counter, newCounter));
return newCounter;