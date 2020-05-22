File saved_items = new File("saved.txt")
BufferedReader stream_in = new BufferedReader(new FileReader(saved_items));
String line;
ArrayList<String> list;
while((line = stream_in.readline)!=null){
       if(line.contains("-----------")){
              break;
        }
       list.add(line.trim());
}