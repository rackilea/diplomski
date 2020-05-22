while (pause) {   // pause is volatile, so it will see the change as soon 
                      // as it is made
        //wait
    }

    System.out.println(msg);  // this line cannot be reached until the value 
                              // of pause has been set to false by the main 
                              // method.  Which under the post Java5
                              // semantics will guarantee that msg will 
                              // have been updated too.