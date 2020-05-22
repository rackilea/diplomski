@Override
    public RemoteWebElement findElement(By by) {
      RemoteWebElement originalElement = super.findElement(by);
      if (originalElement == null){
      return null;
      }
      return new RemoteWebElementWrapper(originalElement);
    }