QueueBrowser browser = null;

try{
  Queue myQueue = session.createQueue(getName());

  //Create the browser and session to be able to iterate
  browser = session.createBrowser(myQueue);
  Enumeration msgs = browser.getEnumeration();