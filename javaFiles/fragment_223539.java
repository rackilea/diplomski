// condition #2
       if (elem != null && ...) {
           it.remove();
           if (it.hasNext()) {
               it.next();
               it.remove();
           }
       }