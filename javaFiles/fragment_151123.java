String path = "D:" + File.pathSeparator + fileSearched + ".txt";

File f = new File(path);

if(f.exists()) {

        //do your stuff

}

//I dont know why would you like to search them as a list but anyways

File dir = new File("D:");

dir.mkdir();

for(String s : dir.list()){
     if(s.equalsIgnoreCase(fileSearched)){
         //do your stuff
     }
}