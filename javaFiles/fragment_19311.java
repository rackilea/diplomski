private Observable<Information> wrapGetInformation(String responseId) {
    return Observable.create(emitter -> {
        noRxClient.getInformation(responseId, new Action1<Information>() {
            @Override
            public void call(Information information) {
                emitter.onNext(information);
                emitter.onComplete();
                //also wrap exceptions into emitter.onError(Throwable)
            }
        });
    });
}

private Observalbe<RenderedResponse> wrapRenderResponse(Response response, Information information) {
    return Observable.fromCallable(() -> {
        return renderResponse(response, information);
        //exceptions automatically wrapped
    });
}