public Observable<String> networkCall1()
{
    return <NETWORK_CALL_1()>
            .subscribeOn(Schedulers.io);
}

public Observable<String> networkCall2( String input )
{
    return <NETWORK_CALL_2(input)>
            .subscribeOn(Schedulers.io);
}

public Observable<String> chainedCalls()
{
    return networkCall1()
            .flatMap( result1 -> networkCall2( result1 ) )
            .observeOn(AndroidSchedulers.mainThread());
}