String osname = System.getProperty("os.name");

if(osname.startsWith("Linux")){
    System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver") 
  }else if(osname.startsWith("Windows")){
    System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver.exe") 
  }