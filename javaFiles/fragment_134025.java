//Trying to find the stem in Trie
     String prefixToCheckLowerCase = prefix.toLowerCase();
     int completionsCount = 0;
     List<String> completions = new LinkedList<String>();
     TrieNode traversal = root;
     for (int i = 0; i < prefixToCheckLowerCase.length(); i++)
     {
         if (traversal.getValidNextCharacters().contains(prefixToCheckLowerCase.charAt(i)))
        {
            traversal = traversal.getChild(prefixToCheckLowerCase.charAt(i));
        } 
         //Means  stem not found, returns an empty list
         else
            return completions;
     }
     //If current word is an end word, increment the counter and add it to compeltions list
     if (traversal.endsWord()) 
     {
         completionsCount=1;
         completions.add(traversal.getText());
     }

     List<TrieNode> nodesToBeSearched = new LinkedList<TrieNode>();
     List<Character> ChildCharaterList = new LinkedList<Character>(traversal.getValidNextCharacters());
     //Filling the list with children of the current node, first level of of the breadth first search 
     for (int i=0; i<ChildCharaterList.size(); i++) 
     {
         nodesToBeSearched.add(traversal.getChild(ChildCharaterList.get(i)));
     }
     //while loop for the linked list elements and see if any compeltions exists , inside it we will also check each node children and add them to the list!!!
     while (nodesToBeSearched!=null  && nodesToBeSearched.size()>0 && completionsCount < numCompletions)
     {
         TrieNode trieNode = nodesToBeSearched.remove(0);
         if (trieNode.endsWord()) 
         {
             completionsCount++;
             completions.add(trieNode.getText());
         }

         List<Character> subTrieNodeCholdren = new LinkedList<Character>(trieNode.getValidNextCharacters());
         //Adding all next level tries to the linked list , kinda recursive!!!
         for (int i=0; i<subTrieNodeCholdren.size();i++) 
         {
             nodesToBeSearched.add(trieNode.getChild(subTrieNodeCholdren.get(i)));
         }
     }
     return completions;