if (is_error_reported()) {
   // A fatal error has happened, the error handler(VMError::report_and_die)
   // should abort JVM after creating an error log file. However in some
   // rare cases, the error handler itself might deadlock. Here we try to
   // kill JVM if the fatal error handler fails to abort in 2 minutes.
   //
   // This code is in WatcherThread because WatcherThread wakes up
   // periodically so the fatal error handler doesn't need to do anything;
   // also because the WatcherThread is less likely to crash than other
   // threads.

   for (;;) {
     if (!ShowMessageBoxOnError
      && (OnError == NULL || OnError[0] == '\0')
      && Arguments::abort_hook() == NULL) {
          os::sleep(this, 2 * 60 * 1000, false);
          fdStream err(defaultStream::output_fd());
          err.print_raw_cr("# [ timer expired, abort... ]");
          // skip atexit/vm_exit/vm_abort hooks
          os::die();
     }

     // Wake up 5 seconds later, the fatal handler may reset OnError or
     // ShowMessageBoxOnError when it is ready to abort.
     os::sleep(this, 5 * 1000, false);
   }
 }