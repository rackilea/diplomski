function mainThread()
{
    var somethingINeed = firstAttempt()
    doSomethingWithReturn(somethingINeed);
}

function firstAttempt()
{
    var ret = doSomethingLong()
    return ret
}