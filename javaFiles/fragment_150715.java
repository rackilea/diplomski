Scanner in = new Scanner(new File("test.txt"));
PrintWriter out = new PrintWriter(new File("out.txt"));
String searchFor = "require(";

while(in.hasNextLine()){
   String tmp = in.nextLine();
   if(tmp.contains(searchFor)){
      String result;
      int index = tmp.indexOf(searchFor) + searchFor.length()+1;
      int endIndex = tmp.indexOf("\"",index);
      String first = tmp.substring(0, index);
      String word = tmp.substring(index, endIndex);
      result = first + "[" + word + "]\")";
      out.println(result);
   }
   else{
      out.println(tmp);
   }
}
out.flush();