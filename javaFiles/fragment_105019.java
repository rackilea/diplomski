if (_sockjs) {
    socketUrl += random(0, 999);
    socketUrl += "/";
    socketUrl += random(0, 999999); // should be a random string, but this works (see )
    socketUrl += "/websocket";
  }