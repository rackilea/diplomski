/**
 * Add the profiler in the run
 * @param profiler profiler class
 * @param initLine profiler options initialization line
 * @return builder
 */
ChainedOptionsBuilder addProfiler(Class<? extends Profiler> profiler,
                                  String initLine);

/**
 * Add the profiler in the run
 * @param profiler profiler class name, or profiler alias
 * @param initLine profiler options initialization line
 * @return builder
 */
ChainedOptionsBuilder addProfiler(String profiler, String initLine);