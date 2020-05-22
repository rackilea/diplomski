private static String OS = System.getProperty("os.name").toLowerCase();
if(OS.indexOf("win") >= 0)
//your code for windows OS.
else if(OS.indexOf("mac") >= 0)
//your code for MAC OS.
else if(OS.indexOf("sunos") >= 0)
//your code for Solaris OS
else if(OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 )
//your code for unix OS's