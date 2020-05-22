try {
    if(executorService.awaitTermination(1, TimeUnit.SECONDS))
        System.out.println("Terminated correctly");
    else
        System.out.println("Termination failed");
} catch (InterruptedException e) {
    e.printStackTrace();
}