Observable.range(1, 50)
    .flatMap(index ->      // for every index make new request
        makeRequest(index) // this shall return Observable<Response>
            .retry(N)      // on error => retry this request N times
            .map(response -> saveToDb(response)), // save and report success
        1                  // limit concurrency to single request-save
    )
    .subscribe();