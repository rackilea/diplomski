for (HttpURLConnection aConnection : collectionOfConnections) {
  try {
    aConnection.setTimeout() ....
    ... probably more code
  }
  catch (WhateverExceptionWouldBeThrown) {
    ... some error handling
  }
}