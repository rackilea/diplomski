Callable<Boolean> testCollumnsTask = new Callable<>(){

           @Override
           public Boolean call(){
              return Boolean.valueOf(testCols(board));
           }
    }