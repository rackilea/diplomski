while(stopFlag){
    stopFlag = false;
    ServerGUIStatistics.mw.setConsoleOutput("New connection from \"" + socket.getInetAddress().toString() + "\" on port " + socket.getPort(), 0);// Prints to a console output window... 
    ServerGUIStatistics.mw.updateConNumber(_totalConnections);
    ServerGUIStatistics.mw.updateConAllTimeNumber(_totalConnectionsAllTime);//Updates a field on the main window which displays the total number of users connected
    boolean stayAlive = true;
    try{
        socket.setSoTimeout(10000);
        BufferedInputStream connectionStatus = new BufferedInputStream(socket.getInputStream());
        do{
            int holder = connectionStatus.read();
            switch(holder){
                case 1:
                    stayAlive = true;
                    break;
                case 0:
                    stayAlive = false;
                    break;
            } 
        }
        while(stayAlive);
    }
    catch(IOException ex){
        ServerGUIStatistics.mw.setConsoleOutput(socket.getInetAddress().toString() + " " + ex.getMessage(), 2); // Prints to a console output window...
    }
    _totalConnections--;
    ServerGUIStatistics.mw.updateConNumber(_totalConnections); //Updates a field on the main window which displays the current number of users connected
    return;
}