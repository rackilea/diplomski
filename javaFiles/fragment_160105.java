int counter = 0;
for(int y = 0; y < mapHeight; y++)
        {
            for(int x = 0; x < mapWidth; x++)
            {                      
                tiles[x][y].number(counter);
                counter++;                    
            }    
        }