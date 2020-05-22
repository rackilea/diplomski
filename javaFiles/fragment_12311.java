public String toString(){
      String result = "";
      for(int i = 0; i < planets.length; i++){
          result += planets[i].toString(); // append comma if you need to separate it,
                          // and most of all handle nulls
      } 
      return result;  
}