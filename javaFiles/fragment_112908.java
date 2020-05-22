if(mazeGrid[x][y] == '1'){
    System.out.println("I Hit A Wall");
    return;
}

if(mazeGrid[x][y] == footSteps){
    System.out.println("I Am Repeating My Steps");
    return;
}