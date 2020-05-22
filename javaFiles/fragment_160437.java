switch (count % 4) {
  case 0 : 
    thepoem += verbs.get(random).toString() + "\n";
    break;
  case 1 :
    thepoem += adverbs.get(random).toString() + " ";
    break;
  case 2 :
    thepoem += adjectives.get(random).toString() + " ";
    break;
  case 3 :
    thepoem += nouns.get(random).toString() + " ";
    break;
}