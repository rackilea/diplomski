try {
   someMethod();
} catch(Exception ex) {
   /* Optional: Log Error */
   Logger.error(..., ex);
   throw new Exception("Error Occurred While Processing Request.", ex);
}