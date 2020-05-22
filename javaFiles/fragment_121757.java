public boolean accept(File dir, String name) {  
    File f = new File(dir, name); // Form the file path "dir/name". 
    String delimiter = " ";  /* delimiter */  
    searchname.searchname = searchname.searchname.toUpperCase(); 

    //Split the search string//
    String [] tempname = searchname.searchname.split(delimiter); 

    if (f.isDirectory()){
        return true; // Don't discard any subdirectories  
    } else {  
        for(int i=0; i<tempname.length; i++){   
            // Toast.makeText(getApplicationContext(), (tempname[i]), Toast.LENGTH_SHORT).show();
            if(name.toUpperCase().contains(tempname[i])) {
                return true;
            }
        }               
    }

    return false;  
}