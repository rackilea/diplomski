URL url = this.getClass().getClassLoader().getResource(classpathRelativeLocation);
File file = new File(url.getFile()); // Strangely, URL.getFile does not return a File
ChromeDriverService.Builder bldr = (new ChromeDriverService.Builder())
                                   .usingDriverExecutable(file)
                                   .usingAnyFreePort();
ChromeDriver driver = new ChromeDriver(bldr.build());