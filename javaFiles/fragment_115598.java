public static boolean contains(List<String> ntfs,String pathname){ 
   for(String s:ntfs){
        if(pathname.contains(s)){
            return true;
        }
    }
    return false;
}