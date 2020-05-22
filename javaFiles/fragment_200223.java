String shutdownCommand;
  StringPP operatingSystem = new StringPP(System.getProperty("os.name"));

  if (operatingSystem.containsIgnoreCase("linux") ||
      operatingSystem.containsIgnoreCase("mac") ||
      operatingSystem.containsIgnoreCase("unix"))
  {
    shutdownCommand = "sudo shutdown -h -t 30";
  }
  else if (operatingSystem.containsIgnoreCase("windows"))
  {
    shutdownCommand = "shutdown /s /d P:0:0 /t 30 /c \"Blue Husky Timer 2 is shutting down your system, as you requested. \n"
        + "You have 30 seconds to save and close programs\"";
  }
  else
  {
    throw new UnsupportedOperationException("Unsupported operating system.");
  }

  try
  {
    Runtime.getRuntime().exec(shutdownCommand);
  }
  catch (Throwable t)
  {
    Main.LOG.logThrowable(t);
  }
  System.exit(0);