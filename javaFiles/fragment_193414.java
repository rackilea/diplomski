Manager manager;
manager = new Manager();
try {
  manager.addAttachListener(new AttachListener() {
    public void attached(AttachEvent ae)
    {
      try
      {
        System.out.println("attached" + ((Phidget)ae.getSource()).getSerialNumber());
      } catch (PhidgetException ex) { }
    }
  });
  manager.open();
} catch (PhidgetException exception) {
  System.err.println(exception.getErrorNumber()+ exception.getDescription());
}
// Allow the Phidgets time to attach
Thread.sleep(1000);