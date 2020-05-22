public static void main(String[] args) {
    System.out.println("Normal back");
    Browser browser = new Browser(); 
   // unwraping the optional or testing it is mandatory to get the object inside in
    browser.back().ifPresent(browser::retrieveSite); 
    // for example it will not compile
    browser.retrieveSite(browser.back()); 
    // of course you could cheat by invoking Optional.get() but that is a bad practice and the absence of object will be detected as soon as the invocation 
    browser.retrieveSite(browser.back().get()); 
  }

  public void retrieveSite(URL url) {
    //...
  }