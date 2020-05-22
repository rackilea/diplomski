long download1 = net.getBytesRecv();
long timestamp1 = net.getTimeStamp();
Thread.sleep(2000); //Sleep for a bit longer, 2s should cover almost every possible problem
net.updateNetworkStats(); //Updating network stats
long download2 = net.getBytesRecv();
long timestamp2 = net.getTimeStamp();
System.out.println("prova " + (download2 - download1)/(timestamp2 - timestamp1));
//Do the correct calculations