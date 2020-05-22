private void findAndAdd(String word, Set<Set<String>> groups) {
     for(Set<String> group: groups) {
         boolean found = false;
         for(String str: group) {
             if(isAnagram(str, word)) {
                 found = true;
             }
             break;
         }
         if(found) {
             groups.remove(group);
             group.add (word);
             groups.add(group);
             return;
         }
     }
     Set<String> set = new HashSet<>();
     set.add(word);
     groups.add(set);
 }