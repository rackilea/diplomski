static class LogListener implements NotifciationListener {
  @Override
  public void handleNotification(Notification notification, Object handback) {
    LOG.info("Notification!"); 
  }   
}