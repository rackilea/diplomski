//Custom class
class CustomForkJoinWorkerThreadFactory : ForkJoinPool.ForkJoinWorkerThreadFactory {
  override fun newThread(pool: ForkJoinPool?): ForkJoinWorkerThread {
    return CustomForkJoinWorkerThread(pool)
  }
}
// helper class (probably only needed in kotlin)
class CustomForkJoinWorkerThread(pool: ForkJoinPool?) : ForkJoinWorkerThread(pool)