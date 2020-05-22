do
    {
        i++;
        q = colorTheMap(map, matrix, r+1, i);
        if(q) return true;
    }
    while(i <= 3);