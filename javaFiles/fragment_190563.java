for (int z = 0; z < chapterKeywords.length; z++) {
   if (chapterKeywords[z] == null) {
      System.out.println("No list found at array index " + z);
      continue;
   }
   iterator = chapterKeywords[z].iterator();
   while (iterator.hasNext()) {
      System.out.println(iterator.next());
   }
}