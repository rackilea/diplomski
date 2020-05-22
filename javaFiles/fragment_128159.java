{
  readData();
  if( isAckExpected && data == ack ) {
    mainThread.ackReceivedSemaphore.notify();
    isAckExpected = false
  }
}