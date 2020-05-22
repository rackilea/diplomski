int i = 0;
    if(!acceptable(map, matrix, r, i)) return false;
    map[r] = i;
    .
    .
    .
    do
    {
        i++;
        q = colorTheMap(map, matrix, r+1, i);
        if(q) return true;
    }
    while(i <= 3);
    map[r] = -1;