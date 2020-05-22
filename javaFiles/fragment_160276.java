testingThread.start();    // starts the other thread

    testingThread.initMsg();  // the other thread may or may not be in the 
                              // while loop by now msg may or may not be 
                              // visible to the testingThread yet
                              // the important thing to note is that either way
                              // testingThread cannot leave its while loop yet

    testingThread.setPause(false);   // after this volatile, all data earlier 
                                     // will be visible to other threads.  
                                     // Thus even though msg was not declared 
                                     // volatile it will piggy back the pauses
                                     // use of volatile; as described [here](http://www.cs.umd.edu/~pugh/java/memoryModel/jsr-133-faq.html#volatile) 

                                     // and now the testingThread can leave 
                                     // its while loop