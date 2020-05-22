if(there are active threads and is there availability on the queue){
    submit to the work queue for the worker threads to pick up // 1
} else {
   if(max pool size is not met){
      create a new thread with this task being its first task // 2
   } else { 
      reject // 3
   }
}