selector.select(timeout);

if (System.currentTimeMS() > sendHeartbeatTime) {
    for(Connection conn: connections) 
        conn.checkAndSendHeartbeat();
}

// in Connection
private long lastSend = System.currentTimeMS();
private long lastRead = System.currentTimeMS();

public void writeData() {
   lastSend = System.currentTimeMS();
   // write data.
}

public void checkAndSendHeartbeat() {
   long now = System.currentTimeMS();
   if (now - lastRead > HEARTBEAT_TIMEOUT) {
      closeConnection();
   else if (now - lastSend > HEATBEAT_INTERVAL)
      writeHeartBeatData();
}