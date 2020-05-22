boolean proximity = false;
for (int i = 0; i < grid.length; i++){
    for(int j = 0; j <  grid[i].length; j++){
        if(grid[i][j] == Pred){  //only care if its a Pred
            //now check for Prey
            //make sure youre not out of bounds!
            if(i+1 < grid.length && grid[i+1][j] == Prey) proximity = true;
            else if(i+1 < grid.length && j+1 < grid[i].length && grid[i+1][j+1] == Prey) proximity = true;
            //do for rest etc.
        }
        if(proximity) break;//once found, youre done.
    }
}