service.doX(..., new AsyncCallback<String> {
  void onSuccess(String str) {
    awesomeness(...);
  } 
});

service.doY(..., new AsyncCallback<String> {
  void onSuccess(String str) {
    awesomeness(...);
  } 
});

void awesomeness(...) {
  // magic stuff
}