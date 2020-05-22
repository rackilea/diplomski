function mainThread()
{
    secondAttempt(method(var ret)
    {
        doSomethingWithReturn(ret);
    })
}

function secondAttempt(functionBlock)
{
    async{
        var ret = doSomethingLong()
        functionBlock(ret)
    }
}