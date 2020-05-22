beanService.processMybeanRPC(mybean, callback);
 AsyncCallback callback = new AsyncCallback()
    {
        public void onFailure(Throwable caught)
        {
           //Do on fail
        }

        public void onSuccess(Object result)
        {
           //Process successfully done with result (result is which you
           // returned in impl class) .
        }
    };