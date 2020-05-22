List<Job> contiguous = new ArrayList<Job>();

/* The boolean variable will be used to track whether the sequence till
   now is contiguous or not */
/* Everytime we add a new unique job, a new contiguous sequence is started.
   So, we will set this variable to `true` */   
boolean isContiguousTillNow = false;