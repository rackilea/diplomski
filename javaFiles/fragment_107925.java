class ColonyNodeView
{
    //rest of your variables and references here
    Square sq; //Added a reference for a 'Square' object
    ColonyNodeView(Square a){
        this.sq=a;
    }
}

//In the other module
for(int i = 0; i<grid.length; i++){
        for(int j = 0; j <grid[i].length; j++){
            grid[i][j]=new Square(); //Initialize it
            ColonyNodeView newSquare = new ColonyNodeView(grid[i][j]);
            //You have now 'linked' the square with the ColonyNodeView. 
            //you can access it by 'newSquare.sq'
            Environment1.add(newSquare, i, j); //Add the ColonyNodeView linked with the Square to Environment. Looks fine now
        }
    }