Producer : queue.add(str); // queue size is now 1
Producer : goes to end of loop
Consumer : String str = queue.poll(); // queue size is now 0
Consumer : process(str, vFlag); // vFlag.value is set to false 
Consumer : String str = queue.poll(); // waits at
            if(queue.size() == 0)
            {
                wait();
            }
Producer : queue.add(str);
Producer : notify() // wakes up consumer
Producer : queue.clear();
Consumer : String str = queue.poll(); // note queue is empty, so returns NULL