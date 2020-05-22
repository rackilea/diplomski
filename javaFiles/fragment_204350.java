return e1.submit(() -> {
    try {
        if (flag) {
            return;
        }
        taskToRun.call();
    } catch (Exception e) {
        System.out.println("garbage ---");
    }
});