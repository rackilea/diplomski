/**
 * Default target factor of leaf tasks for parallel decomposition.
 * To allow load balancing, we over-partition, currently to approximately
 * four tasks per processor, which enables others to help out
 * if leaf tasks are uneven or some processors are otherwise busy.
 */
static final int LEAF_TARGET = ForkJoinPool.getCommonPoolParallelism() << 2;