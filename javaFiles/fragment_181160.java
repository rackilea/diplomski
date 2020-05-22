public String toString(){
      String result = "";
      for(int i = 0; i < myBoard.size(); i++){
          for(int j = 0; j < myBoard.get(i).size(); j++){
              result += myBoard.get(i).get(j);
          }
          // System.out.println();
          result += "\n";
      }
      return result;
  }