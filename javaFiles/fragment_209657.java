boolean addedMountain=false;
int i = r.nextInt(numberOfRows);
int j = r.nextInt(numberOfColumns);
while(addedMountain==false){
    if(terrain[i][k].getType()=="Land"){ //just to give you an idea
        terrain[i][k] = new MountainTerrain();
        addedMountain=true;
    }
    else{
        //try again?
        i = r.nextInt(limit);
        j = r.nextInt(limit);
    }
}