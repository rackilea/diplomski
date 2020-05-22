public static void getDirectory(String dir){
    File place = new File(dir);
    if(place.isDirectory()){
        File[] files = place.listFiles();
        for(File f : files){
            if(f.isDirectory()){
                System.out.println(f.getName());
                getDirectory(f.toString());
            } else{
                System.out.println(f.getName());
            }
        }
    }
}


public static void main(String[] args) {
    getDirectory("Numbers/");
}