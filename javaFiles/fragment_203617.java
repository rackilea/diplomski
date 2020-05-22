Notifier.getInstance().subscribe("user/new", (new Notifiable<User>() {
    @Override
    public void onEvent(User data) {
        logger.info("User name: " + u.getUsername());
    }
}));