private String getImagePath(String name, ArrayList<File> files){
   for(int i=0; i<files.size(); i++){
       if(name.equals(files.get(i).getName())){
          return files.get(i).getAbsolutePath();
       }
   }
   return "";
}