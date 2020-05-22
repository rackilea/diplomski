for(int i=0; i < aFile.length; i++) {
    long lastDate = aFile[i].lastModified();  // get last modified date
    long nowTime = nDate.getTime();  // get the current time to compare
    if(nowTime - lastDate < 600*1000) {  // if less than 10 min
        String pathFile = aFile[i].getPath(); 
        aImagePath.add(pathFile);  // populate the Array
    }
}