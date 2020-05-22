for (int i = 0; i < 3; i++) {
  Thread.sleep(2000); //select your sleep time
  try {
    reopenMyServerSocket();
    break;
  }
  catch (IOException iox) {}
}