public void buttonClick(ClickEvent event) {
    if (SessionLockModSchema.INSTANCE.isLocked(model) {
        try {
            SessionLockModSchema.INSTANCE.lockSchema(model);
            // do something with "model"
        } finally {
            SessionLockModSchema.INSTANCE.unlockSchema(model);
        }
    }
}