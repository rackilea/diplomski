Multimap<String, FileObject> wordToFiles = HashMultimap.create();
wordToFiles.put("first", somefile);
wordToFiles.put("first", anotherfile);
for (FileObject file : wordToFiles.get("first"){
   doSomethingWithFile (file);
}