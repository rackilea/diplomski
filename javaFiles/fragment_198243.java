executor.shutdown();

while (true) {
    try {
        if (executor.awaitTermination(1, TimeUnit.HOURS)) {
            break;
        }
    } catch (InterruptedException ex) {
    }
}

System.out.println(synchList); //Show collection