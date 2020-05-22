public  List<String> globalList;
public static void main(String[] args) 
{
   globalList=newArrayList<String>();
   File folder = new File("\\Documents\\Files");
   File[] listOfFiles = folder.listFiles();

   for(File file : listOfFiles) {
       dosomething(file);
   }

   for(String t : globalList) {
        System.out.println(t);
    }
}
public static void dosomething(File file)
{
    try {

        BufferedReader in = new BufferedReader(new FileReader(file));
        String str;
        while((str = in.readLine()) != null){
            globalList.add(str);
         }
     }
     reader.close();
 }