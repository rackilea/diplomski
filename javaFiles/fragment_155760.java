Set<File> queued = ...
Queue<File> toProcess = 


// add to the queue if its a new entry.
if(queued.add(file)) 
    toProcess.add(file);