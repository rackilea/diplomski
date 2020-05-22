try {
  connection.connect();
  try {
    yourCustomReadMethodThatThrowsSocketTimeoutException(connection);
  } catch (SocketTimeoutException e) {
    Log.e("asdf", "this is a read timeout");
  }
} catch (SocketTimeoutException e) {
  Log.e("asdf", "this is a connect timeout");
}