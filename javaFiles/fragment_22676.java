CountDownLatch doneSignal = new CountDownLatch(requests.length());

for (Request req : requests) {
  ConnectorRunner connectorRunner = new ConnectorRunner(doneSignal);
  connectorRunner.setConnection(DBonnection.getConnection());
  executorService.execute(connectorRunner);
}

doneSignal.await();
DBonnection.dispose();