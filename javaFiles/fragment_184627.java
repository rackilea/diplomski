// Your filename list    
String[] imageList = getAssets().list("images");

// New list 
List<String> myList = new ArrayList<String>();

// For each file name, if the filename ends with jpg or jpeg, add it into "my list"
for(String filename : imageList) {
    if(filename.toLowerCase().endsWith(".jpg") || filename.toLowerCase().endsWith(".jpeg")) {
        myList.add(filename);
    }
}