for (i = 0; i < 2; i++) {
    if(threads[i] == null) {
        (threads[i] = new ClientThread(client, threads, i + 1)).start();
        break;
    }
}