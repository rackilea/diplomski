List<Thread> killList = new ArrayList<Thread>();
   ....
    for (int i = 0; i < 4; i++) {
        Slave slaveThread = new Slave();
        slaveMonitor.add(slaveThread);
    }
    killList.addAll(slaveMonitor);
    killList.add(this);