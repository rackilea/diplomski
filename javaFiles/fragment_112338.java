bool check(int[] arr, int[] ans)
    int same = 0
    for(int i = 0; i < temp.length; i++){
        if(temp[i] == ans[i])
            same++;
    if (same == 4)
        return true;
    return false;