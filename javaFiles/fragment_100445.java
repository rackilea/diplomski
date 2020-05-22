final class ApiResponseError {

    // Since incoming DTO are read-only data bags in most-most cases, even getters may be noise here
    // Gson can strip off the final modifier easily
    // However, primitive values are inlined by javac, so we're cheating javac with Integer.valueOf
    final int code = Integer.valueOf(0);
    final String message = null;

}