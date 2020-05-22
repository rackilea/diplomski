public void processFile(File[] files, int index) {
   if(index < 0 || index >= files.length) return;
   File fileToProcess = files[index];  
   //processing logic   
   processFile(files, index + 1);  
}