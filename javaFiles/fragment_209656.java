// feels my islands up with the dislay character of "+"
for(int i = 0; i < randomRowSize; i++)  {
    terrain[randomRow + i][randomColumn] = new LandTerrain();
    for(int k = 0; k < randomColumnSize; k++)  {
        if(r.nextInt(10)>8){ //10% probability
            terrain[randomRow+i][randomColumn + k] = new MountainTerrain();

        }
    }
}