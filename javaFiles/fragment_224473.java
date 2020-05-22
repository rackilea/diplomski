Logger myLogger = Log.createLogger("/home/coralblocks/logs/", "myLogFile.log");

myLogger.log(byteArray);
myLogger.log(stringBuilder);
myLogger.log(byteBuffer);
myLogger.log("This is a message!", "a=", a, "b=", b);
// log as much as you want...

// you can also do:
myLogger.drainAndWait(); // blocking call

// and when you are done:

myLogger.close(); // non-blocking call

// or:
myLogger.drainCloseAndWait(); // blocking call