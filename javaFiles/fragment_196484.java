File flag = new File("/path/scriptStatus.off");
String message;
if (flag.delete())
  message = "Script enabled.";
else if (flag.createNewFile()) 
  message = "Script disabled.";
else
  /* Maybe missing directory, wrong permissions, race condition. */
  message = "Error: script state unknown.";