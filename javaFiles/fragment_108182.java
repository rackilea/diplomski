Path directory = ...;
Files.walk(directory)
     .forEach(p -> {
         try {
                // same code ....
         } catch (IOException e) {
             // FIXME to handle
         }

     });