File file = new File("some/path/filename.txt");
boolean firstRun = false;
if(!file.exists()){
    firstRun = true;
    file.createNewFile();
}
if(firstRun){
    // Code to run if it is the first time running the app
}else{
    // Code to run if it is not the first time running the app
}