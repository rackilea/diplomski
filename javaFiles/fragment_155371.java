//'main' method must be in a class 'Rextester'.
//Compiler version 1.8.0_111

import java.util.*;
import java.lang.*;

class Rextester
{  
public static void main(String args[])
{
    List<String> startmarkups = new ArrayList<>();
    List<String> endmarkups = new ArrayList<>();
    List<String> texts = new ArrayList<>();
    String s1 = "<b> Hi </b> i'm a <i> beautifull </i> <u> string </u>";
    //Get startmarkup and endmarkups into respective array
    String mk[] = s1.split(">");
    for(int i = 0; i < mk.length; i++){
        System.out.println(mk[i]);
        if(!mk[i].trim().startsWith("<")){
            if(mk[i].indexOf("<") >= 0){
                if(mk[i].indexOf("/") >= 0){
                    endmarkups.add("</"+(mk[i].split("/")[1])+">");
                    startmarkups.add("<"+(mk[i].split("<")[1])+">");
                }else{
                    endmarkups.add("");
                    startmarkups.add("");
                }
            }
        }
    }
    //Get text into texts array
    for(int i = 0; i < mk.length; i++){
        if(!mk[i].trim().startsWith("<")){
            if(mk[i].indexOf("<") >= 0)
                texts.add((mk[i].split("<")[0]));
        }
    }
    for(int i = 0; i < startmarkups.size(); i++) {
        System.out.print("Startmarkup: " + startmarkups.get(i) + "\t");
        System.out.print("Text: " + texts.get(i) + "\t");
        System.out.print("Endmarkup: " + endmarkups.get(i) + "\t");
        System.out.println();
    }

}
}