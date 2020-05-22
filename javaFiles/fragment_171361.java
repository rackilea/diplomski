public static int reqNewThread(){
    synchronize(currThread) {
        if (currThreads.size() >= maxThreads) return -1;
        ++lastGrantedId;
        currThreads.add(lastGrantedId);
        return lastGrantedId;
    }
}