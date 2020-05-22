private boolean eventFired = false;

textArea.addValueChangeHandler(new ValueChangeHandler<String>() {
    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        fireHandlers();
    }
});

button.addClickHandler(new ClickHandler() {
    @Override
    public void onClick(ClickEvent event) {
        fireHandlers();
    }
});

//............

private void fireHandlers() {
    if(!eventFired) {
        eventFired = true;
        for (MyProcessHandler handler : myHandlersList) {
            handler.handle();
        }
    }
}

//............

public static interface MyProcessHandler {
    public void handle();
}

//............

addMyProcessHandler(new MyProcessHandler() {
    @Override
    public void handle() {
        AsyncCallback<String[]> ac = new AsyncCallbackAdapter<String[]>() {
            public void onSuccess(String[] data) {
                eventFired = false;
                //post processing
            }

            @Override
            public void onFailure(Throwable throwable) {
                super.onFailure(throwable);
                eventFired = false;
            }
        };
        RemoteCall.getMyService().getResultFromData(textArea.getData(), ac);
    }
});