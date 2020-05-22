public static void run(Service callableService) {
    executor.submit(() -> {
        Service result = callableService.call();
        run(result.restart());
        return result;
    });
}