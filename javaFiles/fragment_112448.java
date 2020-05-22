mainLoop:
for (int i = 0; i != someVariable; i++) {
    //do something
    nestedLoop:
    for (int ii = 0; ii != someOtherVariable; ii++) {
        //some code...
        /*
        ** Here, you can then skip the remainder of the "nestedLoop" block,
        ** and start the next iteration of the "mainLoop" using `continue mainLoop;`
        */
         //some more code...
    }
}