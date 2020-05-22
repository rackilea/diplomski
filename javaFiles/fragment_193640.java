import java.util.ArrayList;
import java.util.List;
class pairwiseCipher{
  public static void main(String[] args){

      char[] key= {'M', 'O', 'N', 'C', 'L', 'E', 'T', 'A', 'B', 'D', 'F', 'G', 'H', 'I', 'J', 'K', 'P', 'Q', 'R', 'S', 'U','V', 'W','X','Y','Z'};
      char[] old = null;
      char[][] neww = null;
      char[][] ans = null;
      String msg= "Fish are birds without wings and birds are fish without fins";
      msg = msg.toUpperCase();

      msg = msg.replace(' ', 'X');
      System.out.println(msg);
      old = msg.toCharArray();
      neww = new char[msg.length()/2][2];
      ans = new char[msg.length()/2][2];
      for(int i=0,j=0; i<msg.length() ; i=i+2,j+=1){
          neww [j][0] = old[i];
          neww [j][1] = old[i+1];
      }

      //this is just to display characters in pairs
      for(int j=0; j<neww.length; j++){
          System.out.print(neww[j][0]+""+neww[j][1] + " ");
      }

      System.out.println();
      List<Character> cList = new ArrayList<Character>();
      for(char c : key) {
          cList.add(c);
      }

      for(int j=0; j<neww.length; j++){

          int x = (cList.indexOf(neww[j][1]) + 1 ) == 26 ? 0 : (cList.indexOf(neww[j][1]) + 1 );
          int y = (cList.indexOf(neww[j][0]) - 1 ) == -1 ? 25 : (cList.indexOf(neww[j][0]) - 1 );

         ans[j][0] = cList.get(x);
         ans[j][1] = cList.get(y);
      }

      for(int j=0; j<ans.length; j++){
          System.out.print(ans[j][0]+""+ans[j][1] + " ");
      }
      //System.out.println(cList.get(0));

  }
}