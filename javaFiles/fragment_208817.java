volatile jint _interrupted;     // Thread.isInterrupted state

// Note:  _interrupted must be jint, so that Java intrinsics can access it.
// The value stored there must be either 0 or 1.  It must be possible
// for Java to emulate Thread.currentThread().isInterrupted() by performing
// the double indirection Thread::current()->_osthread->_interrupted.
....
volatile bool interrupted() const                 { return _interrupted != 0; }