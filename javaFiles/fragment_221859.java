public File findFile(File dir, String name) {
    File[] children = dir.listFiles();
    try{
        for(File child : children) {
            if(child.isDirectory()) {
               File found = findFile(child, name);
               if(found != null) return found;
            } else {
                if(name.equals(child.getName())) return child;
            }
        }
    }catch(Exception e){
        //ignore here because we have no access to this folder
        return null;
    }

    return null;
}