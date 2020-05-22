public void collision() {
    Rectangle body = jan.getBody();
    int bodyX = (int) body.getX();
    int bodyY = (int) body.getY();
    int clampedBodyX = Math.min(Math.max(0, bodyX), 780);
    int clampedBodyY = Math.min(Math.max(0, bodyY), 360);
    if (bodyX != clampedBodyX || bodyY != clampedBodyY) {
      body.setLocation(clampedBodyX, clampedBodyY);
      jan.setBody(body);
    }
  }