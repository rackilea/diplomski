groovy:000> class MyException extends Exception {
groovy:001>     public Throwable fillInStackTrace() {}}
===> true
groovy:000> e = new MyException()
===> MyException
groovy:000> Arrays.asList(e.stackTrace)
===> []