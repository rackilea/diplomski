boolean Q1 = false;
boolean Q2 = false;
...

if (point.equals(points.get(0))) { // User clicks quest 1
    Q1 = true;
    ...

...
if (checkQuests()){
    //do stuff if all buttons are clicked
}

...

public boolean checkQuests(){ //cleaner if you use arrays
   if(Q1 == false || Q2 == false || ... Q5== false){
      return false;
   }
   else{
      return true;
   }
}