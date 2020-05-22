private boolean isParentOfTarget(MultiTreeNode<Person> suspect, Person target, 
  ArrayList<MultiTreeNode<Person>> chain) { 
    // Check whether the suspect is the target
    if (suspect.getElement().equals(target)) { 
       // Suspect is actually the target :|
       // No need to append to chain here!
       return true; //just head home
    } 
    else {             
       // Yet to find the target. So we check the children of the suspect
       for (MultiTreeNode<Person> child : suspect.getChildren()) {
         // The children may also have children
         // Hence we do a recursive call 
         if(isParentOfTarget(child, target, chain)){
          // Suspect is guilty :)
          chain.add(suspect); 
          return true; //head home
         } 
         // ...At this point
         // Johnny is still lost... Continue Search!
       } 
       return false; //Suspect not guilty :(
     }
 }