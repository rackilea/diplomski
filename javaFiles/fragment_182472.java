override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
    val completed = AtomicBoolean(false)
    val requestHandlingThread = Thread.currentThread()
    val timeout = timeoutsPool.schedule({
        if (completed.compareAndSet(false, true)) {
            requestHandlingThread.interrupt()
        }
    }, 5, TimeUnit.SECONDS)

    try {
        filterChain.doFilter(request, response)
        timeout.cancel(false)
    } finally {
        completed.set(true)
    }
}