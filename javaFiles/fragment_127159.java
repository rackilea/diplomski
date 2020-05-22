function boolean allUnique(String input){
 for( int i=0; i<input.length(); i++ ){
  if( input.indexOf(input.charAt(i),i) > -1 ){ return false; }
  }

 return true;
 }