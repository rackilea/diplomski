// @ IStreamsProxy
synchronized( someMonitor ) {
  someMonitor.wait( /* time? */ );
}

// @ Listener
synchronized( someMonitor ) {
  someMonitor.notify();
}