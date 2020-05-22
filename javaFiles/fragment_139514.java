if (batteryLevel(context) == 1.0){  //1.0 means 100%
    //Do your stuff
    return Result.success()
}else{
    return Result.retry()
}