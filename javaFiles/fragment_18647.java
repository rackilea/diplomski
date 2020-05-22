class Stopwatch {
 final TimeSource timeSource;
 @Inject Stopwatch(TimeSource TimeSource) {
   this.TimeSource = TimeSource;
 }
 void start() { ... }
 long stop() { ... }
}