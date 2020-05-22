TreeSet<File> pages = new TreeSet<File>(new Comparator<File>(){
   public int compare(File first, File second) {
      return first.getName().compareTo(second.getName());
   }
});

for (File file : allFiles) {
   pages.add(file());
}

allFiles = pages.toArray();