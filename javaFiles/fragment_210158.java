if (isNewDay()) { //then rotate and close.
    new FileHandler("C:/Users/Administrator/Desktop/Logging%g.txt",0,5, false).close();
}

//Open the log file.
FileHandler fhandler = new FileHandler("C:/Users/Administrator/Desktop/Logging%g.txt", 1024*1024,10, true);