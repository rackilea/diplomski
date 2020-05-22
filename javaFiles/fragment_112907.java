if(myMaze[x][y] == 'E'){
    count++;
    myMaze[x][y] = footSteps;
    System.out.println(myMaze);
    mazeSolvedFlag = true;
}