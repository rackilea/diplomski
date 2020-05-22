For(File file: dir){
while(!file.renameTo(file)){
Thread.sleep(1)
}
// In my code I check to see if the file name is already in the list which 
// contains files that have been previously loaded if its not I add it to a list
// of files to be processed
}