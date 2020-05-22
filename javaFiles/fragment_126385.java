try {
   someMethod();
} catch(Exception ex) {
   /* Optional: Log Error */
   Logger.error(..., ex);
   throw new CustomException("Error Occurred While Processing Request.", ex);
}