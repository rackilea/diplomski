File lastModified = null;
String directory = "."; // replace with your directory
File[] files = new File(directory).listFiles();
if(files != null){
    Arrays.sort(files, new Comparator<File>(){
        @Override
        public int compare(File o, File t){
            // reverse the ordering so the newest file is first in the array
            return -1 * Long.compare(o.lastModified(), t.lastModified());
        }
    });
    lastModified = files[0];
}