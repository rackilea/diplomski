public String[] getImages(String[] fileNames){
    //assuming fileNames is initialized 
    for(int i=0;i<50;i++){
        fileNames[i]= allData[i][10];
    }
    return fileNames;
}