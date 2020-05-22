Callback callback = new Callback() {
  public void successCallback(String channel, Object response) {
    System.out.println(response.toString());
  }
  public void errorCallback(String channel, PubnubError error) {
    System.out.println(error.toString());
  }
};
pubnub.publish("demo", "Hello World !!" , callback);