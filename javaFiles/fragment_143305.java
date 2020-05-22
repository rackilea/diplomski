LocalService manager = ...; // this is not thread safe
CompletionService exec = new ExecutorCompletionService( ... );
List<URL> work = ...;
for( URL url : work ) {
   // this is existing code returning Runnable
   Runnable task = createTaskFor(url);
   exec.submit(task, url);
}
// we will report the URLs in the order they complete
for( int i = 0; i < work.size(); i++) {
   URL completed = exec.take();
   // manager isn't thread safe, so all calls to it are on this thread
   manager.reportCompleted(completed);
}