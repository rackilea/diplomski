String[] myStringArray = {"a","b","c","a","d","e","f"};

int occurrences = 0;

for(int i=0; i<myStringArray.length;i++{
     if(myStringArray[i].equalsIgnoreCase("a"){
          occurrences++;
          if(occurrences == 2) {
              // Do something
          }
     }
}