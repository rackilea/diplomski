boolean endOfGame = false;
...
do {
    ...
    if (  INput.equals("quit") 
       || (INput.equals("shoot") && ammo == 0)
       || (Userammo == 0 && output == 1) ) {
         endOfGame = true;
    } 
    ...
} while (!endOfGame);