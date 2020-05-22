for(int i=0; i<result.length; i++){
   res.next();
   for(int j=0; j<numfields; j++) {
      result[i][j] = res.getInt("field"+j);
   }
}