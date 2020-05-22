do {
        System.out.println("In Progress");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } while (poolMainExecutor.getActiveCount() != 0);

    System.out.println("Completed");