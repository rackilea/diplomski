public Observable<String> networkCall1()
{
    return <NETWORK_CALL_1()>
            .subscribeOn(Schedulers.io)
            .observeOn(AndroidSchedulers.mainThread());
}

public Observable<String> networkCall2( String input )
{
    return <NETWORK_CALL_2(input)>
            .subscribeOn(Schedulers.io)
            .observeOn(AndroidSchedulers.mainThread());
}

public Observable<String> chainedCalls()
{
    return networkCall1()
            .observeOn(Schedulers.io)
            .flatMap( result1 -> networkCall2( result1 ) )
            .observeOn(AndroidSchedulers.mainThread());
}