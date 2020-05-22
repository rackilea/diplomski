File file = new File("lib", jacobDllVersionToUse);
    System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
    AutoItX x = new AutoItX();
    x.run("C:\\Program Files (x86)\\Microsoft Office\\Office12\\WINWORD.EXE");
    x.winActivate("[CLASS:OpusApp]");
    x.winWait("[CLASS:OpusApp]");
    x.sleep(1000);
    x.send("this is some text");