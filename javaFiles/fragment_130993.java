import java.util.ArrayList;
import java.util.List;

class Solution{
    public static void main(String args[]){
        String arr[] = {"aokk","ok"};
        List<Integer> index = new ArrayList<Integer>();
        for(int i=0;i<arr[0].length();i++){
            for(int j=0;j<arr[1].length();j++){
                if(arr[0].charAt(i)==arr[1].charAt(j) && index.contains(j)==false){
                    System.out.print(arr[0].charAt(i)); //print if it matches
                    index.add(j);//add index to list so it won't count again
                    break;
                }
            }
        }
    }
}