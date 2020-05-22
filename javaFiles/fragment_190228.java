private Runnable createPoller() {
    return () ->
            this.taskExecutor.execute(() -> {
                int count = 0;
                while (this.initialized && (this.maxMessagesPerPoll <= 0 || count < this.maxMessagesPerPoll)) {
                    if (pollForMessage() == null) {
                        break;
                    }
                    count++;
                }
            });
}