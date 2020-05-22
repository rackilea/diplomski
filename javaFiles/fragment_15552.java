final AsyncCallback<String> sweetCallback = new AsyncCallback<String> {
  void onSuccess(String str) {
    // magic stuff
  } 
}

service.doX(..., sweetCallback);

service.doY(..., new AsyncCallback<String> {
  void onSuccess(String str) {

    if (whatever)
      sweetCallback.onSuccess(str);
  } 
}