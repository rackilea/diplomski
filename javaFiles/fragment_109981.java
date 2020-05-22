LARGE_INTEGER current_count;
QueryPerformanceCounter(&current_count);
double current = as_long(current_count);
double freq = performance_frequency;
jlong time = (jlong)((current/freq) * NANOSECS_PER_SEC);
return time;