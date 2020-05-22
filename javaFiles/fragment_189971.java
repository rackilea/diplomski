outerloop:
for(int rowNum=startPosX;rowNum<=endPosX;rowNum++){
    for(int colNum=startPosY;colNum<=endPosY;colNum++){
        if(...){
          //code
          totals.put(client, count+1);
          break outerloop;
        }
    }
}