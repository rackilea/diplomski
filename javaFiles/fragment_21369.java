Map<Integer, ActiveQueue> data = new HashMap<Integer, ActiveQueue>();
    for(ActiveQueue queue : activeQueueList) {
        if(!data.containsKey(queue.CYCLE_ID)) {
            data.put(queue.CYCLE_ID, new ArrayList<ActiveQueue>);                
        } 

        data.get(queue.CYCLE_ID).add(queue);
    }