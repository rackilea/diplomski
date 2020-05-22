private static int searchThread(ArrayList<Thread> threads, String name) {
    int status = ERROR_NOTFOUND;
    for (int i = 0; i < threads.size(); i++) {
        Thread thread = threads.get(i);
        String temp = thread.getName();
        Boolean bool = temp.equals(name);
        if (bool) {
            status = i;
        }
    }
    return status;
}