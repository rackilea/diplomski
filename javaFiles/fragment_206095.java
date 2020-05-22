public Integer getNextAvailable() {
    Integer machineId = null;
    VMallocation allocation;

    // busyListIsFull is a volatile variable that has to be shared between the 2 classes:
    // the one that contains getNext... and the one that modifies busyList
    //this should be added to the code that modifies busyList
    /*
    if(busyList.containsAll(mapAll.keySet())) {
    busyListIsFull = true;
    notifyAll();
    }
     */

    // all machines are busy
    while(busyListIsFull) {
        try {
            wait();
        } catch (InterruptedException e) {

        }
    }
    busyListIsFull = false;
    notifyAll();

    for(Map.Entry<Integer, VMallocation> entry: mapAll.entrySet()) {
        machineId = (Integer)(entry.getKey());
        allocation = (VMallocation)(entry.getValue());
        // allocate the next machineId if it is not busy and has available allocations
        if(!busyList.contains(machineId) &&
                allocation.getCurrentAlloc() < allocation.getMaxAlloc()) {
            System.out.println("allocating machineId:" + machineId);
            allocation.setCurrentAlloc(allocation.getCurrentAlloc() + 1);
            if(machineId != null) {
                return machineId;
            }
        }
    }
    // no machineId was returned if code execution gets here, so no
    //resource was available; now free them all
    for(Map.Entry<Integer, VMallocation> entry: mapAll.entrySet()) {
        allocation = (VMallocation)(entry.getValue());
        allocation.setCurrentAlloc(0);
    }
    // return first available machine
    return getNextAvailable();
}