void run() {
   // only do one access to the expensive `volatile` field
   String nameCopy = name;
   if (nameCopy != null) {
      print(nameCopy);
   }
}