public native void exportPaymentProcessComplete()/*-{
    var that = this;
    console.log('exportingPaymentProcessComplete');
    $wnd.paymentProcessComplete = $entry(function(result){
        that.@com.ec.client.checkout.Presenter::paymentProcessComplete(Ljava/lang/String;)(result);
    });
}-*/;