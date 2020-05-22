int[] walk(String path) {
   int[] position = {0,0};
   int countUP = ( path.split("UP", -1).length ) - 1; //Counts how many UP command
   int countLEFT = ( path.split("LEFT", -1).length ) - 1; //Counts how many LEFT command
   int countRIGHT = ( path.split("RIGHT", -1).length ) - 1; //Counts how many RIGHT command
   int countDOWN = ( path.split("DOWN", -1).length ) - 1; //Counts how many DOWN command
   position[0] = countRIGHT - countLEFT;
   position[1] = countUP - countDown;
   return position;
}