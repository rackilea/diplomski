int listAmount;
    if(eh.size()%BLOCK_SIZE != 0)
        listAmount = eh.size()/BLOCK_SIZE + 1;
    else
        listAmount = eh.size()/BLOCK_SIZE;

    List<bleh>[] lists = new List[listAmount];

    for(int i = 1; i <= listAmount; i++){
        if(i * BLOCK_SIZE < eh.size()){
            lists[i - 1] = eh.subList( (i - 1) * BLOCK_SIZE, eh.size());
        }
        else{
            lists[i - 1] = eh.subList( (i - 1) * BLOCK_SIZE, i * BLOCK_SIZE);
        }
    }