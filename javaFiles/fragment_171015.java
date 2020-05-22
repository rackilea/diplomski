private volatile QueryResult _latestValidResult;

//...

    _latestValidResult = result;

//...

    QueryResult latestValidResult = _latestValidResult;
    apiCallsTotal = latestValidResult.getRateLimitStatus().getLimit();
    apiCallsLeft = latestValidResult.getRateLimitStatus().getRemaining();