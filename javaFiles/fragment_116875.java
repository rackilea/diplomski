static String fn_Z_getTimeDifference(Long startTime, Long endTime)
{
    long processTime = endTime - startTime;
    long days = processTime / 86400000L;
    processTime -= days * 86400000L;
    long hours = processTime / 3600000L;
    processTime -= hours * 3600000L;
    long mins = processTime / 60000L;
    processTime -= mins * 60000L;
    long seconds = processTime / 1000L;
    processTime -= seconds * 1000L;
    long milliSeconds = processTime ;
    return (Long.toString(hours)+ ":" + Long.toString(mins) + ":" + Long.toString(seconds) + ":" + Long.toString(milliSeconds)).toString();
}