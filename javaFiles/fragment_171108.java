public static void main(String[] args) {
    System.out.println("Normal back");
    Browser browser = new Browser(); 
    // No unwrapping is necessary to get the url. 
    // So the robustness of the code depends on the developer habits
    browser.retrieveSite(browser.back());     
  }

  public void retrieveSite(URL url) {        
    //...
  }