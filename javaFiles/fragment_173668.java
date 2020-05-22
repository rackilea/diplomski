pocket.put(new Object(){

            @Override
             public String toString() {
                 return "My Object String";
             }

             //You can override other methods of java.lang.Object

             //note that, because your reference type is java.lang.Object, 
             //so you will NOT be able to call inner(), 
             // 'field' members even if you add them here
        });