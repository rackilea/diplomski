public void deleteFunction(int id){ 
         //...
         if(id<path.size()){
          File file = new File(path.get(id)); 
          boolean deleted = file.delete();
         }
        }