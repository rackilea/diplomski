if (jArray != null) { 

         for (int i=0;i<jArray.size();i++){ 
             myList.add(new ProductModel((JsonObject) jArray.get(i)));
         }
     }