Executor executor = Executors.newSingleThreadExecutor();

@Override
public void handle(KeyEvent event) {
    log.debug("handle getCode: {}", event.getCode());
    executor.execute(() -> {
        switch (event.getCode()) {
            case NUMPAD0:
                sendCommand(HELLO);
                break;
            case NUMPAD1:
                sendCommand(TIME);
                break;
            case NUMPAD2:
                sendCommand(START_TOUR);
                break;
            case DIGIT1:
                sendCommand(JOKE);
                break;
        }
    });
}