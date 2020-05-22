val task = Runnable::class.proxying(::throwsAJavaCheckedException)

//  v-- the result return by catch-block immediately if no exception occurs
val result : Unit = catch(task::run).by { actual: Throwable ->
    val exceptional: Unit = Unit;
    //    v--- you can choose return an exceptional value or rethrow the exception
    when (actual) {
        is RuntimeException -> exceptional
        is ParseException -> logger.info(acutal)
        else -> throw actual
    }
}


val result : Unit? = catch(task::run).only { actual:Throwable ->
// only handle the exception don't return the exceptional value
    logger.info(actual);
}