String lastElement = null;
int counter = 0;
for(String s : inStrings){
  if(lastElement == null){
    lastElement = s;
    counter = 1;
    continue;
  }
  if(!s.equals(lastElement)){
    System.out.println(lastElement + ": " + counter);
    lastElement = s;
    counter = 1;
  }
  else
    counter++;
}

if(lastElement != null)
   System.out.println(lastElement + ": " + counter);