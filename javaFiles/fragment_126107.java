1. No exception at all:
   Some code executed
   Some final code executed
 2. SomeException is thrown:
   Some code (may be partially) executed  
   SomeException code executed
   Some final code executed
 3. SomeOtherException is thrown:
   Some code (may be partially) executed
   Some final code executed
   throw new myException("whatever message required");
 4. SomeStrangeException is thrown 
   Some code (may be partially) executed 
   Some final code executed
   System'll look for other try {} catch {} block to catch SomeStrangeException