import java.util.ArrayList;


public class Test{
public String[] dict = new String[] {"hi","das","bad","fenster","esel","bahi","tfshi"};
public char[] input = new char[]{'a','b','d','h','i','s','f','t'};
public String longestString = dict[0];

public Test() {
    System.out.println(longestString);
    ArrayList<String> convert = new ArrayList<String>();
    for(String counter : dict)
        convert.add(counter);
    getInstance(convert, 0, input.length, 0, 0);
    System.out.println("\n\n\n" + longestString);


}


private void getInstance(ArrayList<String> searching, int pos, int length, int starter, int currentI) {
        int i = starter;
        do{

            ArrayList<String> matched = new ArrayList<String>();
            for(String counter : searching) {
                if(counter.length() > pos) {
                    if(counter.charAt(pos) == input[i]){
                        matched.add(counter);
                    }
                }
            }
            if(matched.size() > 0) {
                getInstance(matched, pos+1,length,(i+1)%length, i%length);
            }
            else if(currentI != i && matched.size() > 0) {
                getInstance(searching,pos,length,(i+1)%length, i%length);
            }
            if(matched.size() > 0 && longestString.length() < matched.get(0).length()){
                longestString = searching.get(0);
            }
            ++i;
            i %= length;
        }while(i != currentI);
}



public static void main(String[] args) {
    new Test();

}
}