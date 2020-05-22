@Override
public boolean equals(Object obj) {//if you insist in using an Object as argument instead of double[][]
   if (!(obj instanceof MyClass)) {
      return false;
   }

   MyClass myObj = (MyClass) obj;
   if(_data.length == myObj._data.length){
      for(int i=0; i<_data.length; i++){
         if(_data[i].length == myObj._data[i].length){
            for(int j=0; j<_data[i].length; j++){
               if(_data[i][j] != myObj._data[i][j]){
                  return false;
               }
            }
         }else{
            return false;
         }
      }
   }else{
      return false;
   }
   return true;
}