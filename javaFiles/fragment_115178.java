if (required vars are absent) {
   start a process that {
     set required vars;
     run another instance of the JVM with the application inside; 
   }
   exit; 
 }
 // here the vars already set 
 do whatever we need in the proper environment