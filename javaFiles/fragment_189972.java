public static move(int client, int x, int y){
    if(storeArray[x][y]==client)
        return;
    int startPosX = Math.max(x-1,0), startPosY=Math.max(y-1,0);
    int endPosX = Math.min(x+1,storeArray.length-1), endPosY = Math.min(y+1,storeArray[0].length-1);
    outerloop:
    for(int rowNum=startPosX;rowNum<=endPosX;rowNum++)
    {
        for(int colNum=startPosY;colNum<=endPosY;colNum++){
            if(storeArray[rowNum][colNum]==client)
            {
                storeArray[x][y]=client;
                System.out.println("Successful move");
                int count = totals.getOrDefault(client, 1);
                totals.put(client, count + 1);
                break outerloop;
                //could set colNum=endPosY+1 and rowNum=endPosX+1 if you don't want to use label/break
            }
        }
    }
}