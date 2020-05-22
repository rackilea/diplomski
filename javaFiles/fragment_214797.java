suspend fun doTheThing() : Result {
    val c = Client()
    try {
        //suspend until the listener fires or we're cancelled
        return suspendCancellableCoroutine {
            cont ->
            c.setListener {
                result -> cont.resume(result)
            }
            c.start()
        }
    } catch (e: Exception) {
        // If someone cancels the parent job, our job will complete exceptionally
        // before the client is done.  Cancel the client since we don't need it
        // anymore
        c.cancel()
        throw e
    }
}