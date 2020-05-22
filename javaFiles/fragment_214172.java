public native void purchase(String token) /*-{

  var instance = this;

  var successHandler = function(status){ // Success handler
    return instance.@com.gw.myProject.client.presenter.payments.PaymentProgramPresenter::test()();
  } 
  var failureHandler = function(status){ // Failure handler
    // $wnd.alert('testing');
  }

  $doc.purchaseAction(token, successHandler, failureHandler);
}-*/;

public void test() {
    this.onHide();
}