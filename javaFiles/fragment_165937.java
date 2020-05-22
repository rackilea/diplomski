RefCountJob ref = new RefCountJob();
// ... do stuff, everybody increments and decrements ref
ref.increment();
// ... do more stuff
ref.increment();
// at the end of your long-running job
ref.schedule();
ref.join();