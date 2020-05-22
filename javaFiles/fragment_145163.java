package parsetest;

import java.util.ArrayList;

public class ParseTest {
 String saR1 = "This is a Test for checking the content and a Test to compare it";
 String saR2 = "This is the second Test for checking the seconds content and a second Test to compare it";
 String diff1 = "";
 String diff2 = "";
 int o3;
 int o4;

 public static void main(String[] args) {
    new ParseTest().parseMethod();
 }

 private void parseMethod() {
  String[] sa1 = saR1.split("\\s"); // split into single words
  String[] sa2 = saR2.split("\\s");

  ArrayList<String> al1 = new ArrayList<String>(); // create ArrayList with more methods to manipulate, avaiable from the api
  ArrayList<String> al2 = new ArrayList<String>();

 for(int o = 0; o<sa1.length; o++) { // adding single elements of array[] to ArrayList
  al1.add(sa1[o]);
 }
 for(int o = 0; o<sa2.length; o++) {
  al2.add(sa2[o]);
 }

  if(al1.size() <= al2.size()) {
  for(int oi = 0; oi<al2.size()+al1.size(); oi++) {
   for(o4 = 0; o4<al2.size(); o4++) {
    for(o3 = 0; o3<al1.size(); o3++) {
     if(al1.size() == al2.size() &&  al2.get(o4).equalsIgnoreCase(al1.get(o3))) {
      al1.remove(al1.get(o3));
      al2.remove(al2.get(o4));
     }
     if(al2.size() > al1.size() && al2.get(o4).equalsIgnoreCase(al1.get(o3))) {  
      al1.remove(al1.get(o3));
      al2.remove(al2.get(o4));
     }
    }
   }
  }
 }

 for(String or1 : al1) { // walking thru the arraylists with remaining elements and printing out results
  diff1 += " " + or1;
 } System.out.println("This is saR1 :" + saR1);
   System.out.println("This is the difference in saR1 :" + diff1);
 for(String or2 : al2) {
  diff2 += " " + or2;
 } System.out.println("This is saR2 :" + saR2);
   System.out.println("This is the difference in saR2 :" + diff2);
}}